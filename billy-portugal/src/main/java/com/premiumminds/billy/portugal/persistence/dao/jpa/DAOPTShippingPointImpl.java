/**
 * Copyright (C) 2013 Premium Minds.
 *
 * This file is part of billy portugal (PT Pack).
 *
 * billy portugal (PT Pack) is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * billy portugal (PT Pack) is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy portugal (PT Pack). If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.portugal.persistence.dao.jpa;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

import com.premiumminds.billy.core.persistence.dao.jpa.DAOShippingPointImpl;
import com.premiumminds.billy.portugal.persistence.dao.DAOPTShippingPoint;
import com.premiumminds.billy.portugal.persistence.entities.PTShippingPointEntity;
import com.premiumminds.billy.portugal.persistence.entities.jpa.JPAPTShippingPointEntity;

public class DAOPTShippingPointImpl extends DAOShippingPointImpl implements
	DAOPTShippingPoint {

	@Inject
	public DAOPTShippingPointImpl(Provider<EntityManager> emProvider) {
		super(emProvider);
	}

	@Override
	public PTShippingPointEntity getEntityInstance() {
		return new JPAPTShippingPointEntity();
	}

	@Override
	protected Class<JPAPTShippingPointEntity> getEntityClass() {
		return JPAPTShippingPointEntity.class;
	}
}