/*
 * Copyright (c) 2008-2012, Hazel Bilisim Ltd. All Rights Reserved.
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

package com.hazelcast.impl;

public enum ClusterOperation {
    //GENERAL
    NONE(0),
    RESPONSE(1),
    LOG(2),
    HEARTBEAT(3),
    JOIN_CHECK(4),
    //EXECUTOR
    REMOTELY_PROCESS(7),
    REMOTELY_PROCESS_AND_RESPOND(8),
    REMOTELY_CALLABLE_BOOLEAN(9),
    REMOTELY_CALLABLE_OBJECT(10),
    EVENT(12),
    EXECUTE(13),
    CANCEL_EXECUTION(14),
    //EVENT LISTENER
    ADD_LISTENER(17),
    ADD_LISTENER_NO_RESPONSE(18),
    REMOVE_LISTENER(19),
    //BLOCKING QUEUE
    BLOCKING_ADD_KEY(21),
    BLOCKING_REMOVE_KEY(22),
    BLOCKING_OFFER_KEY(23),
    BLOCKING_GENERATE_KEY(24),
    BLOCKING_ITERATE(25),
    BLOCKING_SIZE(26),
    BLOCKING_TAKE_KEY(27),
    BLOCKING_CANCEL_TAKE_KEY(28),
    BLOCKING_SET(29),
    BLOCKING_PEEK_KEY(30),
    BLOCKING_GET_KEY_BY_INDEX(31),
    BLOCKING_GET_INDEX_BY_KEY(32),
    BLOCKING_QUEUE_POLL(33),
    BLOCKING_QUEUE_OFFER(34),
    BLOCKING_QUEUE_SIZE(35),
    BLOCKING_QUEUE_PEEK(36),
    BLOCKING_QUEUE_REMOVE(37),
    BLOCKING_QUEUE_REMAINING_CAPACITY(38),
    BLOCKING_QUEUE_ENTRIES(39),
    //CONCURRENT_MAP
    CONCURRENT_MAP_PUT(50),
    CONCURRENT_MAP_PUT_ALL(51),
    CONCURRENT_MAP_PUT_TRANSIENT(52),
    CONCURRENT_MAP_SET(53),
    CONCURRENT_MAP_MERGE(54),
    CONCURRENT_MAP_ASYNC_MERGE(55),
    CONCURRENT_MAP_WAN_MERGE(56),
    CONCURRENT_MAP_TRY_PUT(57),
    CONCURRENT_MAP_PUT_AND_UNLOCK(58),
    CONCURRENT_MAP_GET(59),
    CONCURRENT_MAP_GET_ALL(60),
    CONCURRENT_MAP_REMOVE(61),
    CONCURRENT_MAP_TRY_REMOVE(62),
    CONCURRENT_MAP_REMOVE_ITEM(63),
    CONCURRENT_MAP_GET_MAP_ENTRY(64),
    CONCURRENT_MAP_GET_DATA_RECORD_ENTRY(65),
    CONCURRENT_MAP_BLOCK_INFO(66),
    CONCURRENT_MAP_BLOCK_MIGRATION_CHECK(67),
    CONCURRENT_MAP_SIZE(68),
    CONCURRENT_MAP_CONTAINS_KEY(69),
    CONCURRENT_MAP_CONTAINS_ENTRY(70),
    CONCURRENT_MAP_ITERATE_ENTRIES(71),
    CONCURRENT_MAP_ITERATE_KEYS(72),
    CONCURRENT_MAP_ITERATE_KEYS_ALL(73),
    CONCURRENT_MAP_ITERATE_VALUES(74),
    CONCURRENT_MAP_LOCK(75),
    CONCURRENT_MAP_IS_KEY_LOCKED(173),
    CONCURRENT_MAP_LOCK_MAP(76),
    CONCURRENT_MAP_UNLOCK(77),
    CONCURRENT_MAP_FORCE_UNLOCK(78),
    CONCURRENT_MAP_UNLOCK_MAP(79),
    CONCURRENT_MAP_BLOCKS(80),
    CONCURRENT_MAP_CONTAINS_VALUE(81),
    CONCURRENT_MAP_PUT_IF_ABSENT(82),
    CONCURRENT_MAP_REMOVE_IF_SAME(83),
    CONCURRENT_MAP_REPLACE_IF_NOT_NULL(84),
    CONCURRENT_MAP_REPLACE_IF_SAME(85),
    CONCURRENT_MAP_TRY_LOCK_AND_GET(86),
    CONCURRENT_MAP_ADD_TO_LIST(87),
    CONCURRENT_MAP_ADD_TO_SET(88),
    CONCURRENT_MAP_MIGRATE_RECORD(89),
    CONCURRENT_MAP_PUT_MULTI(90),
    CONCURRENT_MAP_REMOVE_MULTI(91),
    CONCURRENT_MAP_VALUE_COUNT(92),
    CONCURRENT_MAP_BACKUP_PUT(93),
    CONCURRENT_MAP_BACKUP_REMOVE(94),
    CONCURRENT_MAP_BACKUP_REMOVE_MULTI(95),
    CONCURRENT_MAP_BACKUP_LOCK(96),
    CONCURRENT_MAP_BACKUP_ADD(97),
    CONCURRENT_MAP_INVALIDATE(98),
    CONCURRENT_MAP_EVICT(99),
    CONCURRENT_MAP_FLUSH(100),
    CONCURRENT_MAP_BACKUP_PUT_AND_UNLOCK(101),
    //TOPIC
    TOPIC_PUBLISH(111),
    //ATOMIC NUMBER
    ATOMIC_NUMBER_ADD_AND_GET(112),
    ATOMIC_NUMBER_GET_AND_ADD(113),
    ATOMIC_NUMBER_GET_AND_SET(114),
    ATOMIC_NUMBER_COMPARE_AND_SET(115),
    //TRANSACTION
    TRANSACTION_BEGIN(120),
    TRANSACTION_COMMIT(121),
    TRANSACTION_ROLLBACK(122),
    DESTROY(125),
    //ID GEN
    GET_ID(126),
    NEW_ID(127),
    //INDEX
    ADD_INDEX(128),
    //CLUSTER
    GET_INSTANCES(130),
    GET_MEMBERS(131),
    GET_CLUSTER_TIME(132),
    //CLIENT
    CLIENT_AUTHENTICATE(135),
    CLIENT_ADD_INSTANCE_LISTENER(136),
    CLIENT_GET_PARTITIONS(137),
    //COUNT DOWN LATCH
    COUNT_DOWN_LATCH_AWAIT(140),
    COUNT_DOWN_LATCH_COUNT_DOWN(141),
    COUNT_DOWN_LATCH_DESTROY(142),
    COUNT_DOWN_LATCH_GET_COUNT(143),
    COUNT_DOWN_LATCH_GET_OWNER(144),
    COUNT_DOWN_LATCH_SET_COUNT(145),
    //SEMAPHORE
    SEMAPHORE_ATTACH_DETACH_PERMITS(150),
    SEMAPHORE_CANCEL_ACQUIRE(151),
    SEMAPHORE_DESTROY(152),
    SEMAPHORE_DRAIN_PERMITS(153),
    SEMAPHORE_GET_ATTACHED_PERMITS(154),
    SEMAPHORE_GET_AVAILABLE_PERMITS(155),
    SEMAPHORE_REDUCE_PERMITS(156),
    SEMAPHORE_RELEASE(157),
    SEMAPHORE_TRY_ACQUIRE(158),
    //LOCK
    LOCK_LOCK(170),
    LOCK_UNLOCK(171),
    LOCK_FORCE_UNLOCK(172),
    /* CONCURRENT_MAP_IS_KEY_LOCKED(173), see above */
    LOCK_IS_LOCKED(174),
    // PARALLEL RESPONSE
    MAP_PUT(201),
    MAP_GET(202),
    REMOTE_CALL(333);

    public static final int LENGTH = 500;

    private static final ClusterOperation[] operations = new ClusterOperation[LENGTH];

    static {
        for (ClusterOperation cop : ClusterOperation.values()) {
            operations[cop.getValue()] = cop;
        }
    }

    private final short value;

    ClusterOperation(int value) {
        this.value = (short) value;
    }

    public short getValue() {
        return value;
    }

    public static ClusterOperation create(short operation) {
        return operations[operation];
    }
}
