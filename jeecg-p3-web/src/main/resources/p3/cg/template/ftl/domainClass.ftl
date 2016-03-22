package ${domainPackage};

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 描述：</b>${className}:${codeName}<br>
 * 实体定义规则
 * 字段不允许存在基本类型，必须都是包装类型(因为基本类型有默认值)
 * 基本数据类型  包装类 byte Byte boolean Boolean short Short char Character int Integer long Long float Float double  Double 
 * @author ${author}
 * @since：${nowDate}
 * @version:1.0
 */
public class ${className} implements Serializable{
	private static final long serialVersionUID = 1L;
	${feilds}
}

