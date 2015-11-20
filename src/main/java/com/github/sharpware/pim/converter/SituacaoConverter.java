package com.github.sharpware.pim.converter;

import static com.google.common.base.Strings.isNullOrEmpty;

import javax.enterprise.context.ApplicationScoped;

import com.github.sharpware.pim.model.Situacao;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

@Convert(Situacao.class)
@ApplicationScoped
public class SituacaoConverter implements Converter<Situacao> {

	@Override
	public Situacao convert(String value, Class<? extends Situacao> type) {
		if (isNullOrEmpty(value)) {
			return null;
		}
		try {
			return Situacao.valueOf(value);
		} catch (Exception ex) {
			throw new ConversionException(new ConversionMessage("is_not_a_valid_Situacao", value));
		}
	}

}
