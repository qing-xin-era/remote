package com.qing.Dao;


import com.qing.pojo.fileSrc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileSrcMapper {
    //增加
    int  addfileSrc(fileSrc fileSrc);
    //删除
    int deletefileSrc(@Param("fileID") int fileID);
    //查询
    List<fileSrc> queryFileListByName(@Param("userName") String userName);

}
