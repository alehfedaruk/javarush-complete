package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry [] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null) {
            return false;
        }
        for (Entry table : table) {
            for (Entry e = table; e != null; e = e.next) {
                if (value.equals(e.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry(hash(key), key, value, indexFor(hash(key),table.length));
    }

    @Override
    public Long getKey(String value) {
        if (value == null) return 0L;
        else {
            for (Entry table : table) {
                for (Entry e = table; e != null ; e = e.next) {
                    if (value.equals(e.value)) {
                        return table.getKey();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null == getEntry(key) ? null : getEntry(key).getValue();
    }

    public int hash(Long k) {
        k ^= (k >>> 20) ^ (k >>> 12);
        return (int) (k ^ (k >>> 7) ^ (k >>> 4));
    }

    public int indexFor (int hash, int length) {
        return hash & (length - 1);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex];
        table[bucketIndex] = new Entry(hash, key, value, entry);
        size++;
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    public void transfer(Entry[] newTable) {
        int newCapacity = newTable.length;
        for (Entry e : table) {
            while(null != e) {
                Entry next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    public void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == (1 << 30)) {
            threshold = Integer.MAX_VALUE;
            return;
        }
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)Math.min(newCapacity * loadFactor, (1 << 30) + 1);
    }

    public Entry getEntry(Long key) {
        if (size == 0)
            return null;

        int hash = (key == null) ? 0 : hash(key);
        for (Entry e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }


}
