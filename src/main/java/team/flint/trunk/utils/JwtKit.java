package team.flint.trunk.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import team.flint.trunk.exception.ServerException;

import java.util.Date;

/**
 * Jwt
 */
public class JwtKit {
    // 密钥
    private final static String SECRET = "hello!";
    // 签发者
    private final static String ISSUER = "flint";
    // JWT 所面向的用户
    private final static String SUBJECT = "admin";

    /**
     * 生成token
     */
    public static String buildToken(Long id) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(SUBJECT)
                .withClaim("id", id)
                .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 100)) // 设置JWT过期时间
                .sign(Algorithm.HMAC256(SECRET));

    }

    /**
     * 校验token
     * @return true通过 false不通过
     */
    public static boolean verifyToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        } catch (JWTVerificationException e){
            throw new ServerException("token无效");
        }
        return true;
    }

    /**
     * 获取用户ID
     */
    public static Long getId(String token) {
        if (token == null) {
            return 0L;
        }
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("id").asLong();
        } catch (Exception e) {
            return 0L;
        }
    }

//    public static void isToken() {
//        verifyToken(ServletUtils.getRequestAttributes().getRequest().getHeader("token"));
//    }
}
