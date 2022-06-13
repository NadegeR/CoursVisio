package fr.eni.coursvisio.contract;

public class ArticleContract {

    public static final String TABLE_NAME = "Articles";

    public static final String COL_ID = "id";
    public static final String COL_NOM = "nom";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_PRIX = "prix";
    public static final String COL_URL = "url";
    public static final String COL_NOTE = "note";
    public static final String COL_IS_ACHAETE = "isAchate";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NOM + " TEXT,"
            + COL_DESCRIPTION + " TEXT,"
            + COL_PRIX + " REAL,"
            + COL_URL + " TEXT,"
            + COL_NOTE + " REAL,"
            + COL_IS_ACHAETE + " INTEGER);";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}
