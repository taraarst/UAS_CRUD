package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_tiaradwiarista_crud_model_ModelSiswaRealmProxy extends com.tiaradwiarista.crud.model.ModelSiswa
    implements RealmObjectProxy, com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface {

    static final class ModelSiswaColumnInfo extends ColumnInfo {
        long idIndex;
        long namaIndex;
        long kelasIndex;

        ModelSiswaColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ModelSiswa");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.namaIndex = addColumnDetails("nama", "nama", objectSchemaInfo);
            this.kelasIndex = addColumnDetails("kelas", "kelas", objectSchemaInfo);
        }

        ModelSiswaColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ModelSiswaColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ModelSiswaColumnInfo src = (ModelSiswaColumnInfo) rawSrc;
            final ModelSiswaColumnInfo dst = (ModelSiswaColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.namaIndex = src.namaIndex;
            dst.kelasIndex = src.kelasIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ModelSiswaColumnInfo columnInfo;
    private ProxyState<com.tiaradwiarista.crud.model.ModelSiswa> proxyState;

    com_tiaradwiarista_crud_model_ModelSiswaRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ModelSiswaColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.tiaradwiarista.crud.model.ModelSiswa>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nama() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.namaIndex);
    }

    @Override
    public void realmSet$nama(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.namaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.namaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.namaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.namaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$kelas() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.kelasIndex);
    }

    @Override
    public void realmSet$kelas(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.kelasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.kelasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.kelasIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.kelasIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ModelSiswa", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nama", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("kelas", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ModelSiswaColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ModelSiswaColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ModelSiswa";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ModelSiswa";
    }

    @SuppressWarnings("cast")
    public static com.tiaradwiarista.crud.model.ModelSiswa createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.tiaradwiarista.crud.model.ModelSiswa obj = realm.createObjectInternal(com.tiaradwiarista.crud.model.ModelSiswa.class, true, excludeFields);

        final com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface objProxy = (com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("nama")) {
            if (json.isNull("nama")) {
                objProxy.realmSet$nama(null);
            } else {
                objProxy.realmSet$nama((String) json.getString("nama"));
            }
        }
        if (json.has("kelas")) {
            if (json.isNull("kelas")) {
                objProxy.realmSet$kelas(null);
            } else {
                objProxy.realmSet$kelas((String) json.getString("kelas"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.tiaradwiarista.crud.model.ModelSiswa createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.tiaradwiarista.crud.model.ModelSiswa obj = new com.tiaradwiarista.crud.model.ModelSiswa();
        final com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface objProxy = (com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
            } else if (name.equals("nama")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nama((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nama(null);
                }
            } else if (name.equals("kelas")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$kelas((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$kelas(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.tiaradwiarista.crud.model.ModelSiswa copyOrUpdate(Realm realm, com.tiaradwiarista.crud.model.ModelSiswa object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.tiaradwiarista.crud.model.ModelSiswa) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.tiaradwiarista.crud.model.ModelSiswa copy(Realm realm, com.tiaradwiarista.crud.model.ModelSiswa newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.tiaradwiarista.crud.model.ModelSiswa) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.tiaradwiarista.crud.model.ModelSiswa realmObject = realm.createObjectInternal(com.tiaradwiarista.crud.model.ModelSiswa.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface realmObjectSource = (com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) newObject;
        com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface realmObjectCopy = (com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$nama(realmObjectSource.realmGet$nama());
        realmObjectCopy.realmSet$kelas(realmObjectSource.realmGet$kelas());
        return realmObject;
    }

    public static long insert(Realm realm, com.tiaradwiarista.crud.model.ModelSiswa object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tiaradwiarista.crud.model.ModelSiswa.class);
        long tableNativePtr = table.getNativePtr();
        ModelSiswaColumnInfo columnInfo = (ModelSiswaColumnInfo) realm.getSchema().getColumnInfo(com.tiaradwiarista.crud.model.ModelSiswa.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$id(), false);
        String realmGet$nama = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$nama();
        if (realmGet$nama != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
        }
        String realmGet$kelas = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$kelas();
        if (realmGet$kelas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.kelasIndex, rowIndex, realmGet$kelas, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tiaradwiarista.crud.model.ModelSiswa.class);
        long tableNativePtr = table.getNativePtr();
        ModelSiswaColumnInfo columnInfo = (ModelSiswaColumnInfo) realm.getSchema().getColumnInfo(com.tiaradwiarista.crud.model.ModelSiswa.class);
        com.tiaradwiarista.crud.model.ModelSiswa object = null;
        while (objects.hasNext()) {
            object = (com.tiaradwiarista.crud.model.ModelSiswa) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$id(), false);
            String realmGet$nama = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$nama();
            if (realmGet$nama != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
            }
            String realmGet$kelas = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$kelas();
            if (realmGet$kelas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.kelasIndex, rowIndex, realmGet$kelas, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.tiaradwiarista.crud.model.ModelSiswa object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.tiaradwiarista.crud.model.ModelSiswa.class);
        long tableNativePtr = table.getNativePtr();
        ModelSiswaColumnInfo columnInfo = (ModelSiswaColumnInfo) realm.getSchema().getColumnInfo(com.tiaradwiarista.crud.model.ModelSiswa.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$id(), false);
        String realmGet$nama = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$nama();
        if (realmGet$nama != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.namaIndex, rowIndex, false);
        }
        String realmGet$kelas = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$kelas();
        if (realmGet$kelas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.kelasIndex, rowIndex, realmGet$kelas, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.kelasIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.tiaradwiarista.crud.model.ModelSiswa.class);
        long tableNativePtr = table.getNativePtr();
        ModelSiswaColumnInfo columnInfo = (ModelSiswaColumnInfo) realm.getSchema().getColumnInfo(com.tiaradwiarista.crud.model.ModelSiswa.class);
        com.tiaradwiarista.crud.model.ModelSiswa object = null;
        while (objects.hasNext()) {
            object = (com.tiaradwiarista.crud.model.ModelSiswa) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$id(), false);
            String realmGet$nama = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$nama();
            if (realmGet$nama != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.namaIndex, rowIndex, realmGet$nama, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.namaIndex, rowIndex, false);
            }
            String realmGet$kelas = ((com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) object).realmGet$kelas();
            if (realmGet$kelas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.kelasIndex, rowIndex, realmGet$kelas, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.kelasIndex, rowIndex, false);
            }
        }
    }

    public static com.tiaradwiarista.crud.model.ModelSiswa createDetachedCopy(com.tiaradwiarista.crud.model.ModelSiswa realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.tiaradwiarista.crud.model.ModelSiswa unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.tiaradwiarista.crud.model.ModelSiswa();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.tiaradwiarista.crud.model.ModelSiswa) cachedObject.object;
            }
            unmanagedObject = (com.tiaradwiarista.crud.model.ModelSiswa) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface unmanagedCopy = (com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) unmanagedObject;
        com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface realmSource = (com_tiaradwiarista_crud_model_ModelSiswaRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nama(realmSource.realmGet$nama());
        unmanagedCopy.realmSet$kelas(realmSource.realmGet$kelas());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ModelSiswa = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nama:");
        stringBuilder.append(realmGet$nama() != null ? realmGet$nama() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{kelas:");
        stringBuilder.append(realmGet$kelas() != null ? realmGet$kelas() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_tiaradwiarista_crud_model_ModelSiswaRealmProxy aModelSiswa = (com_tiaradwiarista_crud_model_ModelSiswaRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aModelSiswa.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aModelSiswa.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aModelSiswa.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
