/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.vfs.jooq;



/**
 * A class modelling foreign key relationships and constraints of tables in 
 * vfs.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final org.jooq.UniqueKey<com.sonicle.webtop.vfs.jooq.tables.records.SharingLinksRecord> SHARING_LINKS_PKEY = org.jooq.impl.Internal.createUniqueKey(com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS, org.jooq.impl.DSL.name("sharing_links_pkey"), new org.jooq.TableField[] { com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.SHARING_LINK_ID }, true);
    public static final org.jooq.UniqueKey<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord> STORES_PKEY = org.jooq.impl.Internal.createUniqueKey(com.sonicle.webtop.vfs.jooq.tables.Stores.STORES, org.jooq.impl.DSL.name("stores_pkey"), new org.jooq.TableField[] { com.sonicle.webtop.vfs.jooq.tables.Stores.STORES.STORE_ID }, true);
}
