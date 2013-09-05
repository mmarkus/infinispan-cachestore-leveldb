package org.infinispan.loaders.leveldb.configuration;

import org.infinispan.commons.configuration.BuiltBy;
import org.infinispan.commons.configuration.ConfigurationFor;
import org.infinispan.configuration.cache.AbstractStoreConfiguration;
import org.infinispan.configuration.cache.AsyncStoreConfiguration;
import org.infinispan.configuration.cache.SingletonStoreConfiguration;
import org.infinispan.loaders.leveldb.LevelDBCacheStore;
import org.iq80.leveldb.CompressionType;
import org.iq80.leveldb.Options;

import java.util.Properties;

/**
 * 
 * @author <a href="mailto:rtsang@redhat.com">Ray Tsang</a>
 * 
 */
@ConfigurationFor(LevelDBCacheStore.class)
@BuiltBy(LevelDBCacheStoreConfigurationBuilder.class)
public class LevelDBCacheStoreConfiguration extends AbstractStoreConfiguration {
   public enum ImplementationType {
      AUTO,
      JAVA,
      JNI
   }

   final private String location;
   final private String expiredLocation;
   final private ImplementationType implementationType;
   final private CompressionType compressionType;
   final private Integer blockSize;
   final private Long cacheSize;
   final private int expiryQueueSize;
   final private int clearThreshold;


   public LevelDBCacheStoreConfiguration(boolean purgeOnStartup, boolean fetchPersistentState, boolean ignoreModifications, AsyncStoreConfiguration async, SingletonStoreConfiguration singletonStore, boolean preload, boolean shared, Properties properties, String location, String expiredLocation, ImplementationType implementationType, CompressionType compressionType, Integer blockSize, Long cacheSize, int expiryQueueSize, int clearThreshold) {
      super(purgeOnStartup, fetchPersistentState, ignoreModifications, async, singletonStore, preload, shared, properties);
      this.location = location;
      this.expiredLocation = expiredLocation;
      this.implementationType = implementationType;
      this.compressionType = compressionType;
      this.blockSize = blockSize;
      this.cacheSize = cacheSize;
      this.expiryQueueSize = expiryQueueSize;
      this.clearThreshold = clearThreshold;
   }

   public String location() {
      return location;
   }

   public String expiredLocation() {
      return expiredLocation;
   }

   public ImplementationType implementationType() {
      return implementationType;
   }

   public CompressionType compressionType() {
      return compressionType;
   }

   public Integer blockSize() {
      return blockSize;
   }

   public Long cacheSize() {
      return cacheSize;
   }

   public int expiryQueueSize() {
      return expiryQueueSize;
   }

   public int clearThreshold() {
      return clearThreshold;
   }

   public Options dataDbOptions() {
      Options options = new Options().createIfMissing(true);

      options.compressionType(compressionType);

      if (blockSize != null) {
         options.blockSize(blockSize);
      }

      if (cacheSize != null) {
         options.cacheSize(cacheSize);
      }

      return options;
   }

   public Options expiredDbOptions() {
      return new Options().createIfMissing(true);
   }
}
