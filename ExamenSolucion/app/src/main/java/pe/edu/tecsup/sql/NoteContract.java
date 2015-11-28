package pe.edu.tecsup.sql;

public final class NoteContract {
    public static final String TABLE_NAME = "note";
    public static final String COLUMN_NAME_ENTRY_ID = "id";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_BODY = "body";
    public static final String COLUMN_NAME_TYPE = "type";
    public static final String[] TYPES = {"ALERT", "INFO", "WARNING"};

    public static final String getCreateTable() {
        return "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ENTRY_ID + " INTEGER PRIMARY KEY   AUTOINCREMENT," +
                COLUMN_NAME_TITLE + " CHAR(50), " +
                COLUMN_NAME_BODY + " TEXT, " +
                COLUMN_NAME_TYPE + " CHAR(1) );";
    }

    public static final String getDropTable(){
        return "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
    }
}