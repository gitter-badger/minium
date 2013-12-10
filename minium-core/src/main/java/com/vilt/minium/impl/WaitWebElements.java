/*
 * Copyright (C) 2013 The Minium Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vilt.minium.impl;

import com.google.common.base.Predicate;
import com.vilt.minium.Duration;
import com.vilt.minium.TimeoutException;
import com.vilt.minium.WebElements;

/**
 * Provides wait methods for {@link WebElements}.
 *
 * @param <T> {@link WebElements} subclass
 * @author rui.figueira
 */
public interface WaitWebElements<T extends WebElements> extends WebElements {

    /**
     * Waits with a specified timeout for this {@link WebElements} to satisfy a
     * given predicate, or throws a {@link TimeoutException} otherwise.
     *
     * @param timeout the timeout. If null, it will use the default timeout
     *        value provided by
     * @param predicate the predicate to wait for.
     * @return a {@link WebElements} {@link  com.vilt.minium.Configuration#defaultInterval()}
     */
    public T wait(Duration timeout, Predicate<? super T> predicate) throws TimeoutException;

    /**
     * Waits with a preset timeout and interval for this {@link WebElements} to
     * satisfy a given predicate, or throws a {@link TimeoutException}
     * otherwise.
     *
     * @param preset the waiting Tpreset, as configured in {@link com.vilt.minium.Configuration#waitingPreset(String)}
     * @param predicate the predicate to wait for.
     * @return a {@link WebElements}
     *         .
     */
    public T wait(String preset, Predicate<? super T> predicate) throws TimeoutException;

    /**
     * Waits with a specified timeout for this {@link WebElements} to satisfy a
     * given predicate, otherwise it just returns.
     *
     * @param timeout the timeout. If null, it will use the default timeout
     *        value provided by
     * @param predicate the predicate to wait for.
     * @return a {@link WebElements}
     *
     * @see {@link com.vilt.minium.Configuration#defaultInterval(Duration)}.
     */
    public T waitOrTimeout(Duration timeout, Predicate<? super T> predicate);

    /**
     * Waits with a preset timeout and interval for this {@link WebElements} to
     * satisfy a given predicate, otherwise it just returns.
     *
     * @param preset the waiting preset
     * @param predicate the predicate to wait for.
     * @return a {@link WebElements}
     *
     * @see {@link com.vilt.minium.Configuration#defaultInterval(Duration)}.
     */
    public T waitOrTimeout(String preset, Predicate<? super T> predicate);
}
