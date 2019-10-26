package com.yp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Data
@Entity
@Table(name = "trip_info")
public class TripInfo  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "start_land")
	@NotNull(message = "出发城市不能为空！！！")
	private Integer startLand;

	@Column(name = "target_land")
	@NotNull(message = "目的地城市不能为空！！！")
	private Integer targetLand;

	@Column(name = "start_date")
	@DateTimeFormat
	@NotNull(message = "出发时间不能为空！！！")
	private java.util.Date startDate;

	@Column(name = "end_date")
	@DateTimeFormat
	@NotNull(message = "结束时间不能为空")
	private java.util.Date endDate;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "trip_list")
	@NotBlank(message = "旅行详细信息不能为空！！！")
	private String tripList;

	@Column(name = "trip_pic")
	@NotBlank(message = "图片不能为空！！！")
	private String tripPic;

	private java.util.Date created;

	private java.util.Date updated;

	@Transient
	private String startLandName;

	@Transient
	private String targetLandName;

}
