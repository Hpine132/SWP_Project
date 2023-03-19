/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Setting;

/**
 *
 * @author Admin
 */
public class settingDAO extends DBContextMySQL {

    public List<Setting> getSettingWithPagging(int page, int pageSzie) {
        List<Setting> listSetting = new ArrayList<>();
        String sql = "select * from setting limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            settingDAO settingDAO = new settingDAO();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), settingDAO.getTypeName(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listSetting.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSetting;
    }

    public int getTotalSetting() {
        List<Setting> listSetting = new ArrayList<>();
        String sql = "select * from setting ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listSetting.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSetting.size();
    }

    public List<Setting> getSettingWithPaggingSort(int page, int pageSzie, String type) {
        List<Setting> listSetting = new ArrayList<>();
        String sql = "select * from setting order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pageSzie);
            st.setInt(2, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            settingDAO settingDAO = new settingDAO();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), settingDAO.getTypeName(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listSetting.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSetting;
    }

    public List<Setting> getSettingListByTittle(int page, int pageSzie, String tittle) {
        List<Setting> listSetting = new ArrayList<>();
        String sql = "select * from setting where setting_title like ? limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            settingDAO settingDAO = new settingDAO();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), settingDAO.getTypeName(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listSetting.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSetting;
    }

    public List<Setting> getSettingListByTittleSort(int page, int pageSzie, String tittle, String type) {
        List<Setting> listSetting = new ArrayList<>();
        String sql = "select * from setting where setting_title like ? order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            settingDAO settingDAO = new settingDAO();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), settingDAO.getTypeName(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listSetting.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSetting;
    }

    public int getTotalSettingListByTittle(String tittle) {
        String sql = "select * from setting where setting_title like ?";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + tittle + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a++;
            }
        } catch (SQLException ex) {

        }
        return a;
    }

    public List<Setting> getSettingListByStatus(int page, int pageSzie, String tittle) {
        List<Setting> listSetting = new ArrayList<>();
        String sql = "select * from setting where status = ? limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tittle);
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listSetting.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSetting;
    }

    public List<Setting> getSettingListByStatusSort(int page, int pageSzie, String tittle, String type) {
        List<Setting> listSetting = new ArrayList<>();
        String sql = "select * from setting where status = ? order by " + type + " limit ? offset ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tittle);
            st.setInt(2, pageSzie);
            st.setInt(3, (page - 1) * pageSzie);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listSetting.add(s);
            }
        } catch (SQLException ex) {

        }
        return listSetting;
    }

    public int getTotalSettingListByStatus(String tittle) {
        String sql = "select * from setting where status = ?";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tittle);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a++;
            }
        } catch (SQLException ex) {

        }
        return a;
    }

    public Setting getSettingById(int id) {
        String sql = "select * from setting where setting_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return s;
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public void updateSetting(String id, String settingTittle, String settingvalue, String display_order, String status, String description) {
        String sql = "UPDATE setting\n"
                + "SET setting_title = ? , setting_value = ? , display_order = ? , status = ? ,description= ? \n"
                + "WHERE setting_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, settingTittle);
            st.setString(2, settingvalue);
            st.setString(3, display_order);
            st.setString(4, status);
            st.setString(5, description);
            st.setString(6, id);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void insertSetting(String typeId,String settingTittle, String settingvalue, String display_order, String status, String description) {
        String sql = "INSERT INTO `swp391`.`setting`\n"
                + "(`type_id`,\n"
                + "`setting_title`,\n"
                + "`setting_value`,\n"
                + "`display_order`,\n"
                + "`status`,\n"
                + "`description`)\n"
                + "VALUES\n"
                + "(?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, typeId);
            st.setString(2, settingTittle);
            st.setString(3, settingvalue);
            st.setString(4, display_order);
            st.setString(5, status);
            st.setString(6, description);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void updateSetting(int id, String type) {
        String sql = "UPDATE setting\n"
                + "SET status = ? \n"
                + "WHERE setting_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, type);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Integer> getCategoryIds() {
        ArrayList<Integer> categoryIds = new ArrayList<>();
        String sql = "select * from setting where type_id=2";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                categoryIds.add(rs.getInt(1));
            }
        } catch (SQLException e) {

        }
        return categoryIds;
    }

    public ArrayList<Integer> getSupporterIds() {
        ArrayList<Integer> supporterIds = new ArrayList<>();
        String sql1 = "";

        return supporterIds;
    }

    public List<Setting> getSettingByTypeId(int id) {
        List<Setting> result = new ArrayList<>();
        String sql = "select * from setting where type_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                result.add(s);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public List<Setting> getTypeSetting() {
        List<Setting> result = new ArrayList<>();
        String sql = "select * from setting where setting_id <10";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Setting s = new Setting(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                result.add(s);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public String getTypeName(int id) {
        String a = "";
        String sql = "SELECT * FROM swp391.setting where setting_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a = rs.getString(3);
            }
        } catch (SQLException ex) {
        }
        return a;
    }

    public List<Setting> getSettingWithFilter(int typeId, int status) {
        List<Setting> listSetting = new ArrayList<>();
        settingDAO settingDAO = new settingDAO();
        String status1 = "";
        if (typeId != -1 && status != -1) {
            String sql = "SELECT * FROM swp391.setting where type_id = ? and status= ? ;";
            try {
                if (status == 1) {
                    status1 = "active";
                } else {
                    status1 = "deactive";
                }
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, typeId);
                st.setString(2, status1);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Setting s = new Setting(rs.getInt(1), settingDAO.getTypeName(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    listSetting.add(s);
                }
            } catch (SQLException ex) {

            }
        }
        if (typeId == -1 && status != -1) {
            String sql = "select * FROM swp391.setting where status= ? ;";
            try {
                if (status == 1) {
                    status1 = "active";
                } else {
                    status1 = "deactive";
                }
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, status1);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Setting s = new Setting(rs.getInt(1), settingDAO.getTypeName(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    listSetting.add(s);
                }
            } catch (SQLException ex) {

            }
        }
        if (typeId != -1 && status == -1) {
            String sql = "select * FROM swp391.setting where type_id = ? ";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, typeId);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Setting s = new Setting(rs.getInt(1), settingDAO.getTypeName(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    listSetting.add(s);
                }
            } catch (SQLException ex) {

            }
        }
        return listSetting;
    }
}
