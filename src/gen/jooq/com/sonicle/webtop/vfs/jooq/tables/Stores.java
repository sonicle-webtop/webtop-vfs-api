/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.vfs.jooq.tables;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Stores extends org.jooq.impl.TableImpl<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>vfs.stores</code>
     */
    public static final Stores STORES = new Stores();

    /**
     * The class holding records for this type
     */
    @java.lang.Override
    public java.lang.Class<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord> getRecordType() {
        return com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord.class;
    }

    /**
     * The column <code>vfs.stores.store_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.Integer> STORE_ID = createField(org.jooq.impl.DSL.name("store_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('vfs.seq_stores'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>vfs.stores.domain_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.String> DOMAIN_ID = createField(org.jooq.impl.DSL.name("domain_id"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>vfs.stores.user_id</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.String> USER_ID = createField(org.jooq.impl.DSL.name("user_id"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>vfs.stores.built_in</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.Short> BUILT_IN = createField(org.jooq.impl.DSL.name("built_in"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>vfs.stores.provider</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.String> PROVIDER = createField(org.jooq.impl.DSL.name("provider"), org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>vfs.stores.name</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.String> NAME = createField(org.jooq.impl.DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>vfs.stores.uri</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.String> URI = createField(org.jooq.impl.DSL.name("uri"), org.jooq.impl.SQLDataType.VARCHAR(512), this, "");

    /**
     * The column <code>vfs.stores.parameters</code>.
     */
    public final org.jooq.TableField<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord, java.lang.String> PARAMETERS = createField(org.jooq.impl.DSL.name("parameters"), org.jooq.impl.SQLDataType.CLOB, this, "");

    private Stores(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord> aliased) {
        this(alias, aliased, null);
    }

    private Stores(org.jooq.Name alias, org.jooq.Table<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord> aliased, org.jooq.Field<?>[] parameters) {
        super(alias, null, aliased, parameters, org.jooq.impl.DSL.comment(""), org.jooq.TableOptions.table());
    }

    /**
     * Create an aliased <code>vfs.stores</code> table reference
     */
    public Stores(java.lang.String alias) {
        this(org.jooq.impl.DSL.name(alias), STORES);
    }

    /**
     * Create an aliased <code>vfs.stores</code> table reference
     */
    public Stores(org.jooq.Name alias) {
        this(alias, STORES);
    }

    /**
     * Create a <code>vfs.stores</code> table reference
     */
    public Stores() {
        this(org.jooq.impl.DSL.name("stores"), null);
    }

    public <O extends org.jooq.Record> Stores(org.jooq.Table<O> child, org.jooq.ForeignKey<O, com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord> key) {
        super(child, key, STORES);
    }

    @java.lang.Override
    public org.jooq.Schema getSchema() {
        return com.sonicle.webtop.vfs.jooq.Vfs.VFS;
    }

    @java.lang.Override
    public java.util.List<org.jooq.Index> getIndexes() {
        return java.util.Arrays.<org.jooq.Index>asList(com.sonicle.webtop.vfs.jooq.Indexes.STORES_AK1, com.sonicle.webtop.vfs.jooq.Indexes.STORES_AK2);
    }

    @java.lang.Override
    public org.jooq.UniqueKey<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord> getPrimaryKey() {
        return com.sonicle.webtop.vfs.jooq.Keys.STORES_PKEY;
    }

    @java.lang.Override
    public java.util.List<org.jooq.UniqueKey<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord>> getKeys() {
        return java.util.Arrays.<org.jooq.UniqueKey<com.sonicle.webtop.vfs.jooq.tables.records.StoresRecord>>asList(com.sonicle.webtop.vfs.jooq.Keys.STORES_PKEY);
    }

    @java.lang.Override
    public Stores as(java.lang.String alias) {
        return new Stores(org.jooq.impl.DSL.name(alias), this);
    }

    @java.lang.Override
    public Stores as(org.jooq.Name alias) {
        return new Stores(alias, this);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public Stores rename(java.lang.String name) {
        return new Stores(org.jooq.impl.DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @java.lang.Override
    public Stores rename(org.jooq.Name name) {
        return new Stores(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @java.lang.Override
    public org.jooq.Row8<java.lang.Integer, java.lang.String, java.lang.String, java.lang.Short, java.lang.String, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
        return (org.jooq.Row8) super.fieldsRow();
    }
}
