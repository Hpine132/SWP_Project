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
import model.ClassSetting;

/**
 *
 * @author User
 */
public class ClassSettingDAO extends DBContextMySQL {

    public List<ClassSetting> getClassSettings(int page, String sortBy, String sortType) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("type")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("title")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("value")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("displayorder")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("status")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting ORDER BY status asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting ORDER BY status desc  LIMIT 5 OFFSET ?";
                }
            }

        } else {
            sql = "SELECT * FROM class_setting LIMIT 5 OFFSET ?";
        }
        List<ClassSetting> result = new ArrayList<>();
        settingDAO sd = new settingDAO();
        ClassDAO cd = new ClassDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setString(1, searchBy);
            st.setInt(1, page * 5 - 5);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public List<ClassSetting> getClassSettingsByTitle(int page, String searchValue, String sortBy, String sortType) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("type")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("title")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("value")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("displayorder")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("status")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                }
            }

        } else {
            sql = "SELECT * FROM class_setting WHERE setting_title like ? LIMIT 5 OFFSET ?";
        }
        List<ClassSetting> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setString(1, searchBy);
            st.setString(1, "%" + searchValue + "%");
            st.setInt(2, page * 5 - 5);
            ResultSet rs = st.executeQuery();
            settingDAO sd = new settingDAO();
            ClassDAO cd = new ClassDAO();
            while (rs.next()) {
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public List<ClassSetting> getClassSettingsByValue(int page, String searchValue, String sortBy, String sortType) {
        String sql = "";
        if (sortBy != null && !sortBy.equals("")) {
            if (sortBy.equals("type")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("title")) {
                if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("value")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("displayorder")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                }
            }
            if (sortBy.equals("status")) {
                if (sortType.equals("asc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY status asc  LIMIT 5 OFFSET ?";
                } else if (sortType.equals("desc")) {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? ORDER BY status desc  LIMIT 5 OFFSET ?";
                }
            }

        } else {
            sql = "SELECT * FROM class_setting WHERE setting_value like ? LIMIT 5 OFFSET ?";
        }
        List<ClassSetting> result = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //st.setString(1, searchBy);
            st.setString(1, "%" + searchValue + "%");
            st.setInt(2, page * 5 - 5);
            ResultSet rs = st.executeQuery();
            settingDAO sd = new settingDAO();
            ClassDAO cd = new ClassDAO();
            while (rs.next()) {
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public List<ClassSetting> getClassSettingFilterByType(int page, String searchBy, String searchValue, String sortBy, String sortType, int filter) {
        String sql = "";
        List<ClassSetting> result = new ArrayList<>();
        if (searchBy != null && !searchBy.equals("")) {
            if (searchBy.equals("value")) {
                if (sortBy != null && !sortBy.equals("")) {
                    if (sortBy.equals("type")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("title")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("value")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("displayorder")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("status")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY status asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? ORDER BY status desc  LIMIT 5 OFFSET ?";
                        }
                    }

                } else {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? and type_id_fk=? LIMIT 5 OFFSET ?";
                }
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setString(1, "%" + searchValue + "%");
                    st.setInt(2, filter);
                    st.setInt(2, page * 5 - 5);
                    ResultSet rs = st.executeQuery();
                    settingDAO sd = new settingDAO();
                    ClassDAO cd = new ClassDAO();
                    while (rs.next()) {
                        ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                        result.add(x);
                    }
                } catch (SQLException ex) {
                }
            }
            if (searchBy.equals("title")) {
                if (sortBy != null && !sortBy.equals("")) {
                    if (sortBy.equals("type")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("title")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("value")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("displayorder")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("status")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY status asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? ORDER BY status desc  LIMIT 5 OFFSET ?";
                        }
                    }

                } else {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? and type_id_fk=? LIMIT 5 OFFSET ?";
                }
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    //st.setString(1, searchBy);
                    st.setString(1, "%" + searchValue + "%");
                    st.setInt(2, filter);
                    st.setInt(2, page * 5 - 5);
                    ResultSet rs = st.executeQuery();
                    settingDAO sd = new settingDAO();
                    ClassDAO cd = new ClassDAO();
                    while (rs.next()) {
                        ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                        result.add(x);
                    }
                } catch (SQLException ex) {
                }
            }

        }
        if (searchBy == null || searchBy.equals("")) {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("type")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("title")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("value")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("displayorder")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE type_id_fk=? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class_setting WHERE type_id_fk=? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, filter);
                st.setInt(2, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO sd = new settingDAO();
                ClassDAO cd = new ClassDAO();
                while (rs.next()) {
                    ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }
        }
        return result;
    }

    public List<ClassSetting> getClassSettingFilterByStatus(int page, String searchBy, String searchValue, String sortBy, String sortType, String filter) {
        String sql = "";
        List<ClassSetting> result = new ArrayList<>();
        if (searchBy != null && !searchBy.equals("")) {
            if (searchBy.equals("value")) {
                if (sortBy != null && !sortBy.equals("")) {
                    if (sortBy.equals("type")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("title")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("value")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("displayorder")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("status")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY status asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? ORDER BY status desc  LIMIT 5 OFFSET ?";
                        }
                    }

                } else {
                    sql = "SELECT * FROM class_setting WHERE setting_value like ? and status=? LIMIT 5 OFFSET ?";
                }
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setString(1, "%" + searchValue + "%");
                    st.setString(2, filter);
                    st.setInt(2, page * 5 - 5);
                    ResultSet rs = st.executeQuery();
                    settingDAO sd = new settingDAO();
                    ClassDAO cd = new ClassDAO();
                    while (rs.next()) {
                        ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                        result.add(x);
                    }
                } catch (SQLException ex) {
                }
            }
            if (searchBy.equals("title")) {
                if (sortBy != null && !sortBy.equals("")) {
                    if (sortBy.equals("type")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("title")) {
                        if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("value")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("displayorder")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                        }
                    }
                    if (sortBy.equals("status")) {
                        if (sortType.equals("asc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY status asc  LIMIT 5 OFFSET ?";
                        } else if (sortType.equals("desc")) {
                            sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? ORDER BY status desc  LIMIT 5 OFFSET ?";
                        }
                    }

                } else {
                    sql = "SELECT * FROM class_setting WHERE setting_title like ? and status=? LIMIT 5 OFFSET ?";
                }
                try {
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setString(1, "%" + searchValue + "%");
                    st.setString(2, filter);
                    st.setInt(2, page * 5 - 5);
                    ResultSet rs = st.executeQuery();
                    settingDAO sd = new settingDAO();
                    ClassDAO cd = new ClassDAO();
                    while (rs.next()) {
                        ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                        result.add(x);
                    }
                } catch (SQLException ex) {
                }
            }
        }
        if (searchBy == null || searchBy.equals("")) {
            if (sortBy != null && !sortBy.equals("")) {
                if (sortBy.equals("type")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY type_id_fk desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY type_id_fk asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("title")) {
                    if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY setting_title desc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY setting_title asc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("value")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY setting_value asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY setting_value desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("displayorder")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY display_order asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY display_order desc  LIMIT 5 OFFSET ?";
                    }
                }
                if (sortBy.equals("status")) {
                    if (sortType.equals("asc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY status asc  LIMIT 5 OFFSET ?";
                    } else if (sortType.equals("desc")) {
                        sql = "SELECT * FROM class_setting WHERE status=? ORDER BY status desc  LIMIT 5 OFFSET ?";
                    }
                }

            } else {
                sql = "SELECT * FROM class_setting WHERE status=? LIMIT 5 OFFSET ?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, filter);
                st.setInt(2, page * 5 - 5);
                ResultSet rs = st.executeQuery();
                settingDAO sd = new settingDAO();
                ClassDAO cd = new ClassDAO();
                while (rs.next()) {
                    ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                    result.add(x);
                }
            } catch (SQLException ex) {
            }
        }
        return result;
    }

    public int count() {
        int count = 0;
        String sql = "select count(*) as numberRecord from class_setting";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result = (double) count / 5;
        return (int) Math.ceil(result);
    }

    public int countSearch(String searchBy, String value) {
        int count = 0;
        String sql = "";
        if (searchBy.equals("title")) {
            sql = "select count(*) as numberRecord from class_setting where setting_title like ?";
        } else {
            sql = "select count(*) as numberRecord from class_setting where setting_value like ?";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + value + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        double result = (double) count / 5;
        return (int) Math.ceil(result);
    }

    public int countFilterType(int value, String searchBy, String searchValue, int filter) {
        int count = 0;
        String sql = "";
        if (searchBy != null && !searchBy.equals("")) {
            if (searchBy.equals("title")) {
                sql = "select count(*) as numberRecord from class_setting where setting_title like ? and type_id_fk=? ";
            } else {
                sql = "select count(*) as numberRecord from class_setting where setting_value like ? and type_id_fk=?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setInt(2, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        } else {
            sql = "select count(*) as numberRecord from class_setting where type_id_fk=?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        }
    }

    public int countFilterStatus(int value, String searchBy, String searchValue, String filter) {
        int count = 0;
        String sql = "";
        if (searchBy != null && !searchBy.equals("")) {
            if (searchBy.equals("title")) {
                sql = "select count(*) as numberRecord from class_setting where setting_title like ? and status=? ";
            } else {
                sql = "select count(*) as numberRecord from class_setting where setting_value like ? and status=?";
            }
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, "%" + searchValue + "%");
                st.setString(2, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        } else {
            sql = "select count(*) as numberRecord from class_setting where status=?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, filter);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            } catch (SQLException ex) {
            }
            double result = (double) count / 5;
            return (int) Math.ceil(result);
        }
    }

    public void updateStatus(int id, String status) {
        String sql = "update class_setting set status=? where setting_id=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public List<ClassSetting> getAllSetting(int type) {
        List<ClassSetting> result = new ArrayList<>();
        String sql = "SELECT * FROM class_setting where type_id_fk = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            settingDAO sd = new settingDAO();
            ClassDAO cd = new ClassDAO();
            while (rs.next()) {
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    public void newSetting(int type, String title, String value, int classid) {
        String sql = "INSERT INTO `swp391`.`class_setting` (`type_id_fk`, `setting_title`, `setting_value`, `class_id_fk`) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, type);
            ps.setString(2, title);
            ps.setString(3, value);
            ps.setInt(4, classid);
            ps.executeUpdate();
            System.out.println("Update success!");
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public int getClassSettings(String searchValue, int id) {
        String sql = "SELECT * FROM class_setting WHERE setting_value like ? and class_id_fk = ?";
        int a = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(2, id);
            st.setString(1, "%" + searchValue + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                a= rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        return a;
    }
    public ClassSetting getById(int id) {
        String sql = "select * from class_setting where setting_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassDAO cd = new ClassDAO();
                settingDAO sd = new settingDAO();
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                return x;
            }
        } catch (SQLException e) {
        }
        return null;
    }    public ClassSetting getById1(int id) {
        String sql = "select * from class_setting where setting_id=? and class_id_fk = 24";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ClassDAO cd = new ClassDAO();
                settingDAO sd = new settingDAO();
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                return x;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    public List<ClassSetting> getAllRoom(int type) {
        List<ClassSetting> result = new ArrayList<>();
        String sql = " select * FROM class_setting where type_id_fk = ? and class_id_fk = 24;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            settingDAO sd = new settingDAO();
            ClassDAO cd = new ClassDAO();
            while (rs.next()) {
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }
    
    public List<ClassSetting> getAllSlot(int type) {
        List<ClassSetting> result = new ArrayList<>();
        String sql = "SELECT * FROM class_setting where type_id_fk = ? and class_id_fk = 24";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            settingDAO sd = new settingDAO();
            ClassDAO cd = new ClassDAO();
            while (rs.next()) {
                ClassSetting x = new ClassSetting(rs.getInt(1), sd.getSettingById(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), cd.getClassById(rs.getInt(6)), rs.getString(7), rs.getString(8));
                result.add(x);
            }
        } catch (SQLException ex) {
        }
        return result;
    }
}
