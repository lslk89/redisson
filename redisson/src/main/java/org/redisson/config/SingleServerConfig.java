/**
 * Copyright 2016 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.config;

import java.net.URI;
import org.redisson.misc.URIBuilder;

/**
 * 
 * @author Nikita Koksharov
 *
 */
public class SingleServerConfig extends BaseConfig<SingleServerConfig> {

    /**
     * Redis server address
     *
     */
    private URI address;

    /**
     * Minimum idle subscription connection amount
     */
    private int subscriptionConnectionMinimumIdleSize = 1;

    /**
     * Redis subscription connection maximum pool size
     *
     */
    private int subscriptionConnectionPoolSize = 50;

    /**
     * Minimum idle Redis connection amount
     */
    private int connectionMinimumIdleSize = 10;

    /**
     * Redis connection maximum pool size
     */
    private int connectionPoolSize = 64;

    /**
     * Database index used for Redis connection
     */
    private int database = 0;

    /**
     * Should the server address be monitored for changes in DNS? Useful for
     * AWS ElastiCache where the client is pointed at the endpoint for a replication group
     * which is a DNS alias to the current master node.<br>
     * <em>NB: applications must ensure the JVM DNS cache TTL is low enough to support this.</em>
     * e.g., http://docs.aws.amazon.com/AWSSdkDocsJava/latest/DeveloperGuide/java-dg-jvm-ttl.html
     */
    private boolean dnsMonitoring = true;

    /**
     * Interval in milliseconds to check DNS
     */
    private long dnsMonitoringInterval = 5000;

    SingleServerConfig() {
    }

    SingleServerConfig(SingleServerConfig config) {
        super(config);
        setAddress(config.getAddress());
        setConnectionPoolSize(config.getConnectionPoolSize());
        setSubscriptionConnectionPoolSize(config.getSubscriptionConnectionPoolSize());
        setDnsMonitoring(config.isDnsMonitoring());
        setDnsMonitoringInterval(config.getDnsMonitoringInterval());
        setSubscriptionConnectionMinimumIdleSize(config.getSubscriptionConnectionMinimumIdleSize());
        setConnectionMinimumIdleSize(config.getConnectionMinimumIdleSize());
        setDatabase(config.getDatabase());
    }

    /**
     * Redis connection pool size
     * <p>
     * Default is <code>64</code>
     *
     * @param connectionPoolSize - pool size
     * @return config
     */
    public SingleServerConfig setConnectionPoolSize(int connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
        return this;
    }
    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }

    /**
     * Redis subscription-connection pool size limit
     * <p>
     * Default is 50
     *
     * @param subscriptionConnectionPoolSize - pool size
     * @return config
     */
    public SingleServerConfig setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
        this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
        return this;
    }
    public int getSubscriptionConnectionPoolSize() {
        return subscriptionConnectionPoolSize;
    }

    /**
     * Set server address. Use follow format -- host:port
     *
     * @param address of Redis
     * @return config
     */
    public SingleServerConfig setAddress(String address) {
        if (address != null) {
            this.address = URIBuilder.create(address);
        }
        return this;
    }
    public URI getAddress() {
        if (address != null) {
            return address;
        }
        return null;
    }
    void setAddress(URI address) {
        if (address != null) {
            this.address = address;
        }
    }

    /**
     * Monitoring of the endpoint address for DNS changes.
     * <p>
     * Applications must ensure the JVM DNS cache TTL is low enough to support this
     * <p>
     * Default is <code>true</code>
     *
     * @param dnsMonitoring flag
     * @return config
     */
    public SingleServerConfig setDnsMonitoring(boolean dnsMonitoring) {
        this.dnsMonitoring = dnsMonitoring;
        return this;
    }
    public boolean isDnsMonitoring() {
        return dnsMonitoring;
    }

    /**
     * Interval in milliseconds to check the endpoint DNS if {@link #isDnsMonitoring()} is true.
     *
     * Default is <code>5000</code>
     *
     * @param dnsMonitoringInterval time
     * @return config
     */
    public SingleServerConfig setDnsMonitoringInterval(long dnsMonitoringInterval) {
        this.dnsMonitoringInterval = dnsMonitoringInterval;
        return this;
    }
    public long getDnsMonitoringInterval() {
        return dnsMonitoringInterval;
    }

    /**
     * Minimum idle subscription connection amount.
     * <p>
     * Default is 1
     * 
     * @param subscriptionConnectionMinimumIdleSize - connections amount
     * @return config
     *
     */
    public SingleServerConfig setSubscriptionConnectionMinimumIdleSize(int subscriptionConnectionMinimumIdleSize) {
        this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
        return this;
    }
    public int getSubscriptionConnectionMinimumIdleSize() {
        return subscriptionConnectionMinimumIdleSize;
    }

    /**
     * Minimum idle Redis connection amount.
     * <p>
     * Default is <code>10</code>
     *
     * @param connectionMinimumIdleSize - connections amount
     * @return config
     */
    public SingleServerConfig setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
        this.connectionMinimumIdleSize = connectionMinimumIdleSize;
        return this;
    }
    public int getConnectionMinimumIdleSize() {
        return connectionMinimumIdleSize;
    }

    /**
     * Database index used for Redis connection
     * Default is <code>0</code>
     *
     * @param database index
     * @return config
     */
    public SingleServerConfig setDatabase(int database) {
        this.database = database;
        return this;
    }
    public int getDatabase() {
        return database;
    }

}
