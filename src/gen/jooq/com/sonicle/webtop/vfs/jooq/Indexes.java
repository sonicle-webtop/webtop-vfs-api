/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.vfs.jooq;



/**
 * A class modelling indexes of tables in vfs.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final org.jooq.Index SHARING_LINKS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("sharing_links_ak1"), com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS, new org.jooq.OrderField[] { com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.SHARING_LINK_ID, com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.LINK_TYPE }, false);
    public static final org.jooq.Index SHARING_LINKS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("sharing_links_ak2"), com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS, new org.jooq.OrderField[] { com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.DOMAIN_ID, com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.USER_ID, com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.LINK_TYPE, com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.STORE_ID, com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.FILE_PATH }, false);
    public static final org.jooq.Index SHARING_LINKS_AK3 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("sharing_links_ak3"), com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS, new org.jooq.OrderField[] { com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.STORE_ID, com.sonicle.webtop.vfs.jooq.tables.SharingLinks.SHARING_LINKS.FILE_PATH }, false);
    public static final org.jooq.Index STORES_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("stores_ak1"), com.sonicle.webtop.vfs.jooq.tables.Stores.STORES, new org.jooq.OrderField[] { com.sonicle.webtop.vfs.jooq.tables.Stores.STORES.DOMAIN_ID, com.sonicle.webtop.vfs.jooq.tables.Stores.STORES.USER_ID, com.sonicle.webtop.vfs.jooq.tables.Stores.STORES.BUILT_IN }, false);
    public static final org.jooq.Index STORES_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("stores_ak2"), com.sonicle.webtop.vfs.jooq.tables.Stores.STORES, new org.jooq.OrderField[] { com.sonicle.webtop.vfs.jooq.tables.Stores.STORES.DOMAIN_ID, com.sonicle.webtop.vfs.jooq.tables.Stores.STORES.USER_ID, com.sonicle.webtop.vfs.jooq.tables.Stores.STORES.NAME }, false);
}
