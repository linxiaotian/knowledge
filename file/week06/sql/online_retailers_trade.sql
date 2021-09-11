用户级别表(user_info)
CREATE TABLE user_info(
  user_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  user_real_name VARCHAR(20) NOT NULL COMMENT '用户真实姓名',
  identity_card_type TINYINT NOT NULL DEFAULT 1 COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  identity_card_no VARCHAR(20) COMMENT '证件号码',
  mobile_phone INT UNSIGNED COMMENT '手机号',
  user_email VARCHAR(50) COMMENT '邮箱',
  gender CHAR(1) COMMENT '性别',
  user_point INT NOT NULL DEFAULT 0 COMMENT '用户积分',
  birthday DATETIME COMMENT '会员生日',
  user_level TINYINT NOT NULL DEFAULT 1 COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  user_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '用户余额',
  create_time DATETIME COMMENT '创建时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_user_id((user_id)
) ENGINE = innodb COMMENT '用户信息表';
用户级别表(user_level_info)
CREATE TABLE user_level_info(
  user_level TINYINT NOT NULL AUTO_INCREMENT COMMENT '会员级别ID',
  level_name VARCHAR(10) NOT NULL COMMENT '会员级别名称',
  min_point INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '该级别最低积分',
  max_point INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '该级别最高积分',
  create_time DATETIME COMMENT '创建时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_user_level(user_level)
) ENGINE = innodb COMMENT '用户级别信息表';
用户地址表(user_addr_info)
CREATE TABLE user_addr_info(
  user_addr_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  user_id INT UNSIGNED NOT NULL COMMENT 'user_info表的自增ID',
  zip SMALLINT NOT NULL COMMENT '邮编',
  province SMALLINT NOT NULL COMMENT '地区表中省份的ID',
  city SMALLINT NOT NULL COMMENT '地区表中城市的ID',
  district SMALLINT NOT NULL COMMENT '地区表中的区ID',
  address VARCHAR(200) NOT NULL COMMENT '具体的地址门牌号',
  is_default TINYINT NOT NULL COMMENT '是否默认',
  create_time DATETIME COMMENT '创建时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_user_addr_id(user_addr_id)
) ENGINE = innodb COMMENT '用户地址表';


商品信息表(product_info)
CREATE TABLE product_info(
  product_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品ID',
  product_core CHAR(16) NOT NULL COMMENT '商品编码',
  product_name VARCHAR(20) NOT NULL COMMENT '商品名称',
  bar_code VARCHAR(50) NOT NULL COMMENT '国条码',
  price DECIMAL(8,2) NOT NULL COMMENT '商品销售价格',
  publish_status TINYINT NOT NULL DEFAULT 0 COMMENT '上下架状态：0下架1上架',
  audit_status TINYINT NOT NULL DEFAULT 0 COMMENT '审核状态：0未审核，1已审核',
	product_pics VARCHAR(1000) NOT NULL COMMENT "商品图片",
  weight FLOAT COMMENT '商品重量',
  length FLOAT COMMENT '商品长度',
  height FLOAT COMMENT '商品高度',
  width FLOAT COMMENT '商品宽度',
  color_type ENUM('红','黄','蓝','黑'),
  production_date DATETIME NOT NULL COMMENT '生产日期',
  lifecycle INT NOT NULL COMMENT '商品有效期',
  descript TEXT NOT NULL COMMENT '商品描述',
  create_time DATETIME COMMENT '创建时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_product_id(product_id)
) ENGINE = innodb COMMENT '商品信息表';

订单信息表(order_info)
CREATE TABLE order_info(
  order_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  order_sn BIGINT UNSIGNED NOT NULL COMMENT '订单编号 yyyymmddnnnnnnnn',
  user_id INT UNSIGNED NOT NULL COMMENT '下单人ID',
  receive_user VARCHAR(10) NOT NULL COMMENT '收货人姓名',
  province SMALLINT NOT NULL COMMENT '省',
  city SMALLINT NOT NULL COMMENT '市',
  district SMALLINT NOT NULL COMMENT '区',
  address VARCHAR(100) NOT NULL COMMENT '地址',
  payment_method TINYINT NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  order_money DECIMAL(8,2) NOT NULL COMMENT '订单金额',
  district_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
  express_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '运费金额',
  payment_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '支付金额',
  express_name VARCHAR(10) COMMENT '快递公司名称',
  express_sn VARCHAR(50) COMMENT '快递单号',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  deliver_time DATETIME COMMENT '发货时间',
  pay_time DATETIME COMMENT '支付时间',
  receive_time DATETIME COMMENT '收货时间',
  order_status TINYINT NOT NULL DEFAULT 0 COMMENT '订单状态',
  order_point INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单积分',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_order_id(order_id)
)ENGINE = innodb COMMENT '订单信息表';

退款表(refund_info)
CREATE TABLE refund_info(
  refund_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '退款ID',
  refund_sn BIGINT UNSIGNED NOT NULL COMMENT '退款编号 yyyymmddnnnnnnnn',
  user_id INT UNSIGNED NOT NULL COMMENT '退款人ID',
  refund_type TINYINT NOT NULL COMMENT '退款方式：1现金，2支付宝，3微信，4银行卡',
  refund_money DECIMAL(8,2) NOT NULL COMMENT '订单金额',
  bank_card_no VARCHAR(100) COMMENT '银行卡号',
  bank_reserve_name VARCHAR(50) COMMENT '银行预留姓名',
  bank_reserve_mobile VARCHAR(50) COMMENT '银行预留手机号',
  refund_status TINYINT NOT NULL DEFAULT 0 COMMENT '退款状态 0-退款中，1-退款成功 2-退款失败',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '退款时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_refund_id(refund_id)
)ENGINE = innodb COMMENT '退款表';