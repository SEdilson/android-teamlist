package com.example.teamlist.database;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class TeamListMigrations {

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Team_new` " +
                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`name` TEXT, " +
                    "`league` TEXT, " +
                    "`division` TEXT, " +
                    "`numberOfTitles` INTEGER NOT NULL)");
            database.execSQL("INSERT INTO Team_new (id, name, league, division, numberOfTitles)" +
                    "SELECT id, name, league, division, numberOfTitles FROM Team");
            database.execSQL("DROP TABLE Team");
            database.execSQL("ALTER TABLE Team_new RENAME TO Team");
        }
    };
    public static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Team ADD COLUMN image TEXT");
        }
    };
    public static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Team_new` " +
                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`name` TEXT, " +
                    "`league` TEXT, " +
                    "`division` TEXT, " +
                    "`numberOfTitles` INTEGER NOT NULL, " +
                    "`image` INTEGER)");
            database.execSQL("INSERT INTO Team_new (id, name, league, division, numberOfTitles, image)" +
                    "SELECT id, name, league, division, numberOfTitles, image FROM Team");
            database.execSQL("DROP TABLE Team");
            database.execSQL("ALTER TABLE Team_new RENAME TO Team");
        }
    };
    public static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Team_new` " +
                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`name` TEXT, " +
                    "`league` TEXT, " +
                    "`division` TEXT, " +
                    "`numberOfTitles` INTEGER NOT NULL, " +
                    "`image` INTEGER NOT NULL)");
            database.execSQL("DROP TABLE Team");
            database.execSQL("ALTER TABLE Team_new RENAME TO Team");
        }
    };
    public static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Team_new` " +
                    "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "`name` TEXT, " +
                    "`league` TEXT, " +
                    "`division` TEXT, " +
                    "`numberOfTitles` INTEGER NOT NULL, " +
                    "`image` INTEGER NOT NULL)");
            database.execSQL("DROP TABLE Team");
            database.execSQL("ALTER TABLE Team_new RENAME TO Team");
        }
    };
    public static final Migration[] MIGRATIONS = {MIGRATION_1_2, MIGRATION_2_3,
            MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6};

}
