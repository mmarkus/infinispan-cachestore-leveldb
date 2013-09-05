package org.infinispan.loaders.leveldb;

import org.infinispan.configuration.cache.PersistenceConfigurationBuilder;
import org.infinispan.loaders.leveldb.configuration.LevelDBCacheStoreConfiguration;
import org.infinispan.loaders.leveldb.configuration.LevelDBCacheStoreConfigurationBuilder;
import org.testng.annotations.Test;

@Test(groups = "unit", testName = "loaders.leveldb.JavaLevelDBCacheStoreTest")
public class JavaLevelDBCacheStoreTest extends LevelDBCacheStoreTest {

   protected LevelDBCacheStoreConfiguration createCacheStoreConfig(PersistenceConfigurationBuilder lcb) {
      LevelDBCacheStoreConfigurationBuilder builder = new LevelDBCacheStoreConfigurationBuilder(lcb);
      builder.read(super.createCacheStoreConfig(lcb));
      builder.implementationType(LevelDBCacheStoreConfiguration.ImplementationType.JAVA);
      return builder.create();
   }
}
