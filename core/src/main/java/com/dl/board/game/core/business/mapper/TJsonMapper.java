package com.dl.board.game.core.business.mapper;

import com.dl.board.game.core.business.entity.TJson;
import com.dl.board.game.core.business.example.TJsonExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface TJsonMapper {
    /**
     * Description:  使用Example统计总数
     *
     * @param  example example
     * @return countByExample 的结果.
     * @mbg.generated
     */
    long countByExample(TJsonExample example);

    /**
     * Description:  根据Example删除
     *
     * @param  example example
     * @return deleteByExample 的结果.
     * @mbg.generated
     */
    int deleteByExample(TJsonExample example);

    /**
     * Description:  根据主键删除
     *
     * @param  id id
     * @return deleteByPrimaryKey 的结果.
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * Description:  插入一条记录
     *
     * @param  record record
     * @return insert 的结果.
     * @mbg.generated
     */
    int insert(TJson record);

    /**
     * Description:  插入一条记录, 实现选择入库
     *
     * @param  record record
     * @return insertSelective 的结果.
     * @mbg.generated
     */
    int insertSelective(TJson record);

    /**
     * Description:  根据Example查询返回数据
     *
     * @param  example example
     * @return selectByExample 的结果.
     * @mbg.generated
     */
    List<TJson> selectByExample(TJsonExample example);

    /**
     * Description:  查询结果选择性返回
     *
     * @param  example example
     * @param  selective selective
     * @return selectByExampleSelective 的结果.
     * @mbg.generated
     */
    List<TJson> selectByExampleSelective(@Param("example") TJsonExample example, @Param("selective") TJson.Column ... selective);

    /**
     * Description:  根据主键查询返回数据
     *
     * @param  id id
     * @return selectByPrimaryKey 的结果.
     * @mbg.generated
     */
    TJson selectByPrimaryKey(Integer id);

    /**
     * Description:  通过主键查询的结果选择性返回
     *
     * @param  id id
     * @param  selective selective
     * @return selectByPrimaryKeySelective 的结果.
     * @mbg.generated
     */
    TJson selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") TJson.Column ... selective);

    /**
     * Description:  Selective选择插入更新增强功能
     *
     * @param  record record
     * @param  example example
     * @return updateByExampleSelective 的结果.
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TJson record, @Param("example") TJsonExample example);

    /**
     * Description:  根据Example更新数据
     *
     * @param  record record
     * @param  example example
     * @return updateByExample 的结果.
     * @mbg.generated
     */
    int updateByExample(@Param("record") TJson record, @Param("example") TJsonExample example);

    /**
     * Description:  根据主键更新数据, 可选择
     *
     * @param  record record
     * @return updateByPrimaryKeySelective 的结果.
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TJson record);

    /**
     * Description:  根据主键更新数据
     *
     * @param  record record
     * @return updateByPrimaryKey 的结果.
     * @mbg.generated
     */
    int updateByPrimaryKey(TJson record);

    /**
     * Description:  查询单条数据
     *
     * @param  example example
     * @return selectOneByExample 的结果.
     * @mbg.generated
     */
    TJson selectOneByExample(TJsonExample example);

    /**
     * Description:  查询单条数据字段选择性返回
     *
     * @param  example example
     * @param  selective selective
     * @return selectOneByExampleSelective 的结果.
     * @mbg.generated
     */
    TJson selectOneByExampleSelective(@Param("example") TJsonExample example, @Param("selective") TJson.Column ... selective);
}