package com.wbkjcom.commons.util;

import com.wbkjcom.commons.lib.Constants;
import com.wbkjcom.commons.manager.TokenManager;
import com.wbkjcom.commons.model.TokenModel;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TokenUtil implements TokenManager {

	private RedisTemplate<Long, String> redis;

	public TokenUtil(RedisTemplate<Long, String> redis) {
		this.redis = redis;
	}

	public TokenModel createToken (long userId) {
		// 使用 uuid 作为源 token
		String token = UUID.randomUUID ().toString ().replace ("-", "");
		TokenModel model = new TokenModel (userId, token);
		// 存储到 redis 并设置过期时间
		redis.boundValueOps (userId).set (token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return model;
	}

	public TokenModel getToken (String authentication) {
		if (authentication == null || authentication.length () == 0) {
			return null;
		}
		String [] param = authentication.split ("_");
		if (param.length != 2) {
			return null;
		}
		// 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
		long userId = Long.parseLong (param [0]);
		String token = param [1];
		return new TokenModel (userId, token);
	}

	public boolean checkToken (TokenModel model) {
		if (model == null) {
			return false;
		}
		String token =redis.boundValueOps (model.getUserId ()).get ();
		if (token == null || !token.equals (model.getToken ())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
		redis.boundValueOps (model.getUserId ()).expire (Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return true;
	}

	public void deleteToken (long userId) {
		redis.delete (userId);
	}
}