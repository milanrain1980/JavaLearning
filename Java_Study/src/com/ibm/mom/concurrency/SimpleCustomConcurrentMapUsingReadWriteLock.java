package com.ibm.mom.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 用读写锁实现的一个线程安全的Map
 * 其中需要特别说明的是并没有实现entrySet()方法，这是因为实现这个方法比较复杂。
 * 另外这里keySet()和values()也没有直接返回Map的视图，而是一个映射原有元素的新视图，
 * 其实这个entrySet()一样，是为了保护原始Map的数据逻辑，防止不正确的修改导致原始Map发生数据错误。
 * 特别说明的是在没有特别需求的情况下没有必要写一个线程安全的Map实现，因为ConcurrentHashMap已经完成了此操作。
 *
 * Notice:
 * ReadWriteLock需要严格区分读写操作，如果读操作使用了写入锁，那么降低读操作的吞吐量，如果写操作使用了读取锁，那么就可能发生数据错误。
 * 
 * @param <K>
 * @param <V>
 */
public class SimpleCustomConcurrentMapUsingReadWriteLock<K, V> implements Map<K, V> {

	final ReadWriteLock lock = new ReentrantReadWriteLock();

	final Lock r = lock.readLock();

	final Lock w = lock.writeLock();

	final Map<K, V> map;

	public SimpleCustomConcurrentMapUsingReadWriteLock(Map<K, V> map) {
		this.map = map;
		if (map == null)
			throw new NullPointerException();
	}

	public void clear() {
		w.lock();
		try {
			map.clear();
		} finally {
			w.unlock();
		}
	}

	public boolean containsKey(Object key) {
		r.lock();
		try {
			return map.containsKey(key);
		} finally {
			r.unlock();
		}
	}

	public boolean containsValue(Object value) {
		r.lock();
		try {
			return map.containsValue(value);
		} finally {
			r.unlock();
		}
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

	public V get(Object key) {
		r.lock();
		try {
			return map.get(key);
		} finally {
			r.unlock();
		}
	}

	public boolean isEmpty() {
		r.lock();
		try {
			return map.isEmpty();
		} finally {
			r.unlock();
		}
	}

	public Set<K> keySet() {
		r.lock();
		try {
			return new HashSet<K>(map.keySet());
		} finally {
			r.unlock();
		}
	}

	public V put(K key, V value) {
		w.lock();
		try {
			return map.put(key, value);
		} finally {
			w.unlock();
		}
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		w.lock();
		try {
			map.putAll(m);
		} finally {
			w.unlock();
		}
	}

	public V remove(Object key) {
		w.lock();
		try {
			return map.remove(key);
		} finally {
			w.unlock();
		}
	}

	public int size() {
		r.lock();
		try {
			return map.size();
		} finally {
			r.unlock();
		}
	}

	public Collection<V> values() {
		r.lock();
		try {
			return new ArrayList<V>(map.values());
		} finally {
			r.unlock();
		}
	}

}
