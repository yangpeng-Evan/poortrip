package com.yp.mapper;

import com.yp.entity.TripInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author yangpeng
 */
public interface TripMapper extends Mapper<TripInfo> {

    @Select("select t.*,cs.name start_land_name,ct.name target_land_name from trip_info t,city cs,city ct where t.start_land = cs.id and t.target_land = ct.id and t.user_id = #{id}")
    List<TripInfo> findAllTripByUserId(@Param("id") Integer id);
}
