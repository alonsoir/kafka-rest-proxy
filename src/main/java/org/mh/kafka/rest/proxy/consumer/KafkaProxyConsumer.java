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

package org.mh.kafka.rest.proxy.consumer;

import com.google.common.collect.Lists;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.mh.kafka.rest.proxy.config.KafkaRestProxyConfiguration;

import java.util.Set;

/**
 * Created by markus on 27/08/16.
 */
public class KafkaProxyConsumer {

    private KafkaConsumer<String, String> consumer;

    public KafkaProxyConsumer(KafkaRestProxyConfiguration configuration) {
        consumer = new KafkaConsumer<>(configuration.getKafka().get("consumer"));
    }

    public ConsumerRecords<String, String> poll(String topic) {
        consumer.subscribe(Lists.newArrayList(topic));
        try {
            return consumer.poll(5000L);
        } finally {
            consumer.commitSync();
            consumer.unsubscribe();
        }
    }

    public Set<String> getTopics() {
        return consumer.listTopics().keySet();
    }

}
