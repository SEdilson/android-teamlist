//package com.example.teamlist.ui;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.view.ContextMenu;
//import android.view.MenuItem;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.teamlist.dao.TeamDAO;
//import com.example.teamlist.models.Team;
//import com.example.teamlist.ui.recycler.adapter.TeamListAdapter;
//
//public class TeamListView {
//
//    private final Context context;
//    private final TeamListAdapter adapter;
//    private final TeamDAO dao = new TeamDAO();
//
//    public TeamListView(Context context) {
//        this.context = context;
//        adapter = new TeamListAdapter(this.context, dao.allTeams());
//    }
//
////    public void confirmRemove(@NonNull final MenuItem item) {
////        new AlertDialog
////                .Builder(context)
////                .setTitle("Removing Team")
////                .setMessage("Are you sure that you wanna remove this team?")
////                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        RecyclerView.Adapter menuInfo =
////                                (RecyclerView.Adapter) item.getMenuInfo();
////////                        Team teamRetrieved = adapter.onBindViewHolder(menuInfo, menuInfo.);
//////                        removeTeam(teamRetrieved);
////                        configureConfirmationDialog();
////                    }
////                })
////                .setNegativeButton("No", null)
////                .show();
////    }
//
//    private void configureConfirmationDialog() {
//        new AlertDialog
//                .Builder(this.context)
//                .setMessage("Team removed successfully")
//                .setPositiveButton("OK", null)
//                .show();
//    }
//
//    private void removeTeam(Team team) {
//        adapter.remove(team);
//        dao.removeTeam(team);
//    }
// }
