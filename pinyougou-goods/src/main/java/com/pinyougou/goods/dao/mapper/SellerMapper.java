package com.pinyougou.goods.dao.mapper;

import com.pinyougou.goods.dao.entity.Seller;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * @author ljn
 */
@Repository
public interface SellerMapper extends Mapper<Seller> {

    void updateStatus(@Param("sellerId")String sellerId, @Param("status")String status);
}