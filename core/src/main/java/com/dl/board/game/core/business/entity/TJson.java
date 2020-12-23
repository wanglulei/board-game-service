package com.dl.board.game.core.business.entity;

import com.base.common.reflection.annotations.g3db_alias;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Table:
 *   t_json
 *
 * @author Ant丶
 * @mbg.generated
 */
@g3db_alias("t_json")
public class TJson implements Serializable {
    /**
     *
     * Column:
     *   t_json.id
     *
     * @mbg.generated
     */
    @g3db_alias("id")
    private Integer id;

    /**
     *
     * Column:
     *   t_json.sname
     *
     * @mbg.generated
     */
    @g3db_alias("sname")
    private String sname;

    /**
     *
     * Column:
     *   t_json.info
     *
     * @mbg.generated
     */
    @g3db_alias("info")
    private String info;

    /**
     * Description:
     *  This field corresponds to the database table t_json
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * Description:
     *  This field corresponds to the database table t_json
     *
     * @mbg.generated
     */
    private Map<String, Boolean> selectiveColumns = new HashMap<String, Boolean>();

    /**
     * Description:
     *  返回 t_json.id 的值
     *
     * @return 字段 t_json.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * Description:
     *  设置 t_json.id 的值.
     *
     * @param id 字段 t_json.id 的值.
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Description:
     *  返回 t_json.sname 的值
     *
     * @return 字段 t_json.sname 的值
     *
     * @mbg.generated
     */
    public String getSname() {
        return sname;
    }

    /**
     * Description:
     *  设置 t_json.sname 的值.
     *
     * @param sname 字段 t_json.sname 的值.
     *
     * @mbg.generated
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * Description:
     *  返回 t_json.info 的值
     *
     * @return 字段 t_json.info 的值
     *
     * @mbg.generated
     */
    public String getInfo() {
        return info;
    }

    /**
     * Description:
     *  设置 t_json.info 的值.
     *
     * @param info 字段 t_json.info 的值.
     *
     * @mbg.generated
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * Description: This method was generated by MyBatis Generator.
     *
     * @return toString 的结果.
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sname=").append(sname);
        sb.append(", info=").append(info);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * Description: This method was generated by MyBatis Generator.
     *
     * @return builder 的结果.
     * @mbg.generated
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Description: This method was generated by MyBatis Generator.
     *
     * @return hasSelective 的结果.
     * @mbg.generated
     */
    public boolean hasSelective() {
        return this.selectiveColumns.size() > 0;
    }

    /**
     * Description: This method was generated by MyBatis Generator.
     *
     * @return hasSelective 的结果.
     * @mbg.generated
     */
    public boolean hasSelective(String column) {
        return this.selectiveColumns.get(column) != null;
    }

    /**
     * Description: This method was generated by MyBatis Generator.
     *
     * @return selective 的结果.
     * @mbg.generated
     */
    public TJson selective(Column ... columns) {
        this.selectiveColumns.clear();
        if (columns != null) {
            for (Column column : columns) {
                this.selectiveColumns.put(column.value(), true);
            }
        }
        return this;
    }

    /**
     * Description:
     *  This class corresponds to the database table t_json
     *
     * @author Ant丶
     * @mbg.generated
     */
    public static class Builder {
        /**
         * Description:
         *  This field corresponds to the database table t_json
         *
         * @mbg.generated
         */
        private TJson obj;

        /**
         * Description: This method was generated by MyBatis Generator.
         *
         * @return Builder 的结果.
         * @mbg.generated
         */
        public Builder() {
            this.obj = new TJson();
        }

        /**
         * Description:
         *  设置 t_json.id 的值.
         *
         * @param id 字段 t_json.id 的值.
         *
         * @mbg.generated
         */
        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        /**
         * Description:
         *  设置 t_json.sname 的值.
         *
         * @param sname 字段 t_json.sname 的值.
         *
         * @mbg.generated
         */
        public Builder sname(String sname) {
            obj.setSname(sname);
            return this;
        }

        /**
         * Description:
         *  设置 t_json.info 的值.
         *
         * @param info 字段 t_json.info 的值.
         *
         * @mbg.generated
         */
        public Builder info(String info) {
            obj.setInfo(info);
            return this;
        }

        /**
         * Description: This method was generated by MyBatis Generator.
         *
         * @return build 的结果.
         * @mbg.generated
         */
        public TJson build() {
            return this.obj;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table t_json
     *
     * @mbg.generated
     */
    public enum Column {
        id("id"),
        sname("sname"),
        info("info");

        /**
         * Description:
         *  This field corresponds to the database table t_json
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * Description: This method was generated by MyBatis Generator.
         *
         * @return value 的结果.
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * Description: This method was generated by MyBatis Generator.
         *
         * @return getValue 的结果.
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * Description: This method was generated by MyBatis Generator.
         *
         * @param  column column
         * @return Column 的结果.
         * @mbg.generated
         */
        Column(String column) {
            this.column = column;
        }

        /**
         * Description: This method was generated by MyBatis Generator.
         *
         * @return desc 的结果.
         * @mbg.generated
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * Description: This method was generated by MyBatis Generator.
         *
         * @return asc 的结果.
         * @mbg.generated
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}