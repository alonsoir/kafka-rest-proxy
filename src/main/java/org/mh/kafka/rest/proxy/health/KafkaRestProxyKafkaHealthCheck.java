/*
 *  Copyright 2016 Markus Helbig
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.mh.kafka.rest.proxy.health;


import org.mh.kafka.rest.proxy.consumer.KafkaProxyConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by markus on 27/08/16.
 */
public class KafkaRestProxyKafkaHealthCheck extends com.codahale.metrics.health.HealthCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaRestProxyKafkaHealthCheck.class);

    private KafkaProxyConsumer kafkaProxyConsumer;

    public KafkaRestProxyKafkaHealthCheck(KafkaProxyConsumer kafkaHealthConsumer) {
        this.kafkaProxyConsumer = kafkaHealthConsumer;
    }

    @Override
    protected Result check() throws Exception {
        try {
            kafkaProxyConsumer.getTopics();
            return Result.healthy("Kafka topics are available.");
        } catch (Exception exception) {
            LOGGER.error("{}",exception.getMessage(),exception);
            return Result.unhealthy(exception);
        }
    }
}
