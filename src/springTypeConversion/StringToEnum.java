package springTypeConversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

@SuppressWarnings("rawtypes")
public class StringToEnum implements ConverterFactory<String, Enum>{

	@Override
	public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToEnumConverter<T>(targetType);
	}
	
	public final class StringToEnumConverter<T extends Enum> implements Converter<String, T>{

		private Class<T> enumType;
		
		public StringToEnumConverter(Class<T> enumType){
			this.enumType = enumType;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public T convert(String source) {
			return (T)Enum.valueOf(this.enumType, source);
		}
	}

}
