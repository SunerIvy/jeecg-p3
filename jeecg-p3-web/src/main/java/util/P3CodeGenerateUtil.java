package util;

import org.jeecgframework.p3.cg.def.FtlDef;
import org.jeecgframework.p3.cg.factory.CodeGenerateFactory;
import org.jeecgframework.p3.core.utils.common.StringUtils;

/**
 * 描述：代码生成器工具类（支持单表）
 * 
 * @author：zhoujf
 * @since：
 * @version:1.0
 */
public class P3CodeGenerateUtil {

	public static void main(String[] args) {
		/** 此处修改成你的 表名 和 中文注释 ***/
		String code_cg_tables = "user";
		if (StringUtils.isEmpty(code_cg_tables)) {
			return;
		}
		String[] tables = code_cg_tables.split(",");
		for (String tableName : tables) {
			CodeGenerateFactory.codeGenerateByFTL(tableName, "", FtlDef.KEY_TYPE_02);
		}
	}
}
