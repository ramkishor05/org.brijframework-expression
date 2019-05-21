package org.brijframework.expression.operators;

import java.util.Collection;

import org.brijframework.expression.base.IOperator;
import org.brijframework.expression.constant.OperatorType;
import org.brijframework.expression.core.Operators;
import org.brijframework.expression.meta.OperatorMeta;
import org.brijframework.expression.util.OperatorUtil;

public class SubOperator extends Operators implements IOperator {
	@SuppressWarnings("rawtypes")
	public Object subtract(Collection _array,String _s) {
		Object aobj[] = _array.toArray();
		Object objResult = null;
		if(aobj.length>0){
			objResult = OperatorUtil.bigDecimalForValue(this.operationValue(aobj[0], _s));
		}
		for (int i = 1; i < aobj.length; i++) {
			objResult=OperatorUtil.subtract(objResult, aobj[i]);
		}
		return objResult;
	}
	
	@SuppressWarnings("rawtypes")
	public Object subtract(Collection _array,String _s,Object obj) {
		Object aobj[] = _array.toArray();
		Object objResult = null;
		if(aobj.length>0){
			objResult = OperatorUtil.bigDecimalForValue(this.operationValue(aobj[0], _s));
		}
		for (int i = 1; i < aobj.length; i++) {
			objResult=OperatorUtil.subtract(objResult, obj);
			objResult=aobj[i];
		}
		return objResult;
	}
	
	

	@SuppressWarnings("rawtypes")
	@Override
	public Object compute(Collection _array, OperatorMeta setup) {
		if(setup.type.contentEquals(OperatorType.Unary.toString())){
			return resultUnarySetup(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Binary.toString())){
			return resultBinarySetups(_array, setup);
		}
		if(setup.type.contentEquals(OperatorType.Ternary.toString())){
			return resultTernarySetup(_array, setup);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultUnarySetup(Collection _array,OperatorMeta setup) {
		return this.subtract(_array, setup.key,setup.param);
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultBinarySetups(Collection _array,OperatorMeta setup) {
		return this.subtract(_array, setup.key,setup.param);
	}
	
	@SuppressWarnings("rawtypes")
	public Object  resultTernarySetup(Collection _array,OperatorMeta setup) {
		return this.subtract(_array, setup.key,setup.param);
	}
	
}
