/**
 * Copyright (C) 2013 Premium Minds.
 * 
 * This file is part of billy core.
 * 
 * billy core is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * billy core is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy core. If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.core.services;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.google.inject.Injector;
import com.premiumminds.billy.core.Config;
import com.premiumminds.billy.core.exceptions.BillyValidationException;
import com.premiumminds.billy.core.exceptions.DuplicateTicketException;
import com.premiumminds.billy.core.persistence.dao.DAOTicket;
import com.premiumminds.billy.core.persistence.entities.TicketEntity;
import com.premiumminds.billy.core.services.entities.Ticket;

public class TicketManager implements Serializable{

	private static final long serialVersionUID = Config.SERIAL_VERSION;
	private final Injector injector;
	DAOTicket daoTicket = null;
	
	public TicketManager(Injector injector){
		this.injector = injector;
		this.daoTicket = injector.getInstance(DAOTicket.class);
	}
	
	public String generateTicket() throws DuplicateTicketException{
		
		Ticket.Builder ticketBuilder = injector.getInstance(Ticket.Builder.class);
		TicketEntity newTicket = (TicketEntity)ticketBuilder.build();
		
		UID uid = new UID(UUID.randomUUID().toString());
		newTicket.setUID(uid);
		
		if(ticketExists(newTicket.getUID().getValue())){
			throw new DuplicateTicketException();
		}
		
		daoTicket.create(newTicket);
		
		return newTicket.getUID().getValue();
		
		
	}
	
	public boolean ticketExists(String ticketUID){
		return daoTicket.exists(new UID(ticketUID));
	}
	
	public void updateTicket(UID ticketUID, UID objectUID, Date creationDate, Date processDate) throws BillyValidationException{
		
		if(!ticketExists(ticketUID.getValue())){
			throw new BillyValidationException();
		}
		
		TicketEntity ticket = daoTicket.get(ticketUID);
		ticket.setCreationDate(creationDate);
		ticket.setProcessDate(processDate);
		ticket.setObjectUID(objectUID);
		
		daoTicket.update(ticket);
	}
}
