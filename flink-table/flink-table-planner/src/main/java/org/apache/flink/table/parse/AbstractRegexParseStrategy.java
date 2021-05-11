/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.parse;

import org.apache.flink.table.operations.Operation;

import java.util.regex.Pattern;

/** Strategy to parse statement to {@link Operation} by regex. */
public abstract class AbstractRegexParseStrategy implements ExtendedParseStrategy {

    protected static final int DEFAULT_PATTERN_FLAGS = Pattern.CASE_INSENSITIVE | Pattern.DOTALL;

    protected Pattern pattern;

    protected AbstractRegexParseStrategy(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean match(String statement) {
        return pattern.matcher(statement.trim()).matches();
    }
}
