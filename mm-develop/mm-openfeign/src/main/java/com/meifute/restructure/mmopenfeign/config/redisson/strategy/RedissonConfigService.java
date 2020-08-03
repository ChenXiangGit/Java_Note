package com.meifute.restructure.mmopenfeign.config.redisson.strategy;

import com.meifute.restructure.mmopenfeign.config.redisson.properties.RedissonProperties;
import org.redisson.config.Config;

/**
 * Redisson配置构建接口
 * @auther liuliang
 * @date 2020/3/31 5:51 PM
 */
public interface RedissonConfigService {
    /**
     * 根据不同的Redis配置策略创建对应的Config
     * @param redissonProperties
     * @return Config
     */
    Config createRedissonConfig(RedissonProperties redissonProperties);
}
