/**
 * Copyright (C) 2013 Premium Minds.
 *
 * This file is part of billy spain (ES Pack).
 *
 * billy spain (ES Pack) is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * billy spain (ES Pack) is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy spain (ES Pack). If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.spain.services.export.pdf.simpleinvoice;

import java.io.InputStream;

import com.premiumminds.billy.gin.services.impl.pdf.AbstractTemplateBundle;
import com.premiumminds.billy.spain.services.export.pdf.ESTemplateBundle;
import com.premiumminds.billy.spain.util.PaymentMechanism;

public class ESSimpleInvoiceTemplateBundle extends AbstractTemplateBundle
	implements ESTemplateBundle {

	private static final String	BANK_TRANSFER_TEXT		= "Transferência bancária";
	private static final String	CASH_TEXT				= "Numerário";
	private static final String	CREDIT_CARD_TEXT		= "Cartão crédito";
	private static final String	CHECK_TEXT				= "Cheque";
	private static final String	DEBIT_CARD_TEXT			= "Cartão débito";
	private static final String	COMPENSATION_TEXT		= "Compensação de saldos em conta corrente";
	private static final String	COMMERCIAL_LETTER_TEXT	= " Letra comercial";
	private static final String	RESTAURANT_TICKET_TEXT	= "Ticket restaurante";
	private static final String	ATM_TEXT				= "Multibanco";
	private static final String	EXCHANGE_TEXT			= "Permuta";

	public ESSimpleInvoiceTemplateBundle(String logoImagePath,
											InputStream xsltFileStream,
											String softwareCertificationId) {

		super(logoImagePath, xsltFileStream);
	}

	@Override
	public String getPaymentMechanismTranslation(Enum<?> pmc) {
		if (null == pmc) {
			return null;
		}
		PaymentMechanism payment = (PaymentMechanism) pmc;
		switch (payment) {
			case BANK_TRANSFER:
				return ESSimpleInvoiceTemplateBundle.BANK_TRANSFER_TEXT;
			case CASH:
				return ESSimpleInvoiceTemplateBundle.CASH_TEXT;
			case CREDIT_CARD:
				return ESSimpleInvoiceTemplateBundle.CREDIT_CARD_TEXT;
			case CHECK:
				return ESSimpleInvoiceTemplateBundle.CHECK_TEXT;
			case DEBIT_CARD:
				return ESSimpleInvoiceTemplateBundle.DEBIT_CARD_TEXT;
			case COMPENSATION:
				return ESSimpleInvoiceTemplateBundle.COMPENSATION_TEXT;
			case COMMERCIAL_LETTER:
				return ESSimpleInvoiceTemplateBundle.COMMERCIAL_LETTER_TEXT;
			case ATM:
				return ESSimpleInvoiceTemplateBundle.ATM_TEXT;
			case RESTAURANT_TICKET:
				return ESSimpleInvoiceTemplateBundle.RESTAURANT_TICKET_TEXT;
			case EXCHANGE:
				return ESSimpleInvoiceTemplateBundle.EXCHANGE_TEXT;
			default:
				return null;
		}
	}
}
