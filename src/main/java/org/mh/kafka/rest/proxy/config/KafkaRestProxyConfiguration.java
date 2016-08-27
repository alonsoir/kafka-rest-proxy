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

package org.mh.kafka.rest.proxy.config;

import io.dropwizard.Configuration;

import java.util.Map;

/**
 * Created by markus on 27/08/16.
 */
public class KafkaRestProxyConfiguration extends Configuration {

    private Map<String, Map<String, Object>> kafka;

    public Map<String, Map<String, Object>> getKafka() {
        return kafka;
    }
}
