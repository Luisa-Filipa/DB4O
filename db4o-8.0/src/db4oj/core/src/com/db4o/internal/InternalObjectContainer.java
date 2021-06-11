/* This file is part of the db4o object database http://www.db4o.com

Copyright (C) 2004 - 2011  Versant Corporation http://www.versant.com

db4o is free software; you can redistribute it and/or modify it under
the terms of version 3 of the GNU General Public License as published
by the Free Software Foundation.

db4o is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
for more details.

You should have received a copy of the GNU General Public License along
with this program.  If not, see http://www.gnu.org/licenses/. */
package com.db4o.internal;

import com.db4o.ext.*;
import com.db4o.foundation.*;
import com.db4o.internal.activation.*;
import com.db4o.internal.callbacks.*;
import com.db4o.internal.events.*;
import com.db4o.internal.query.*;
import com.db4o.reflect.*;

/**
 * @exclude
 * @sharpen.partial
 */
public interface InternalObjectContainer extends ExtObjectContainer {
    
    public void callbacks(Callbacks cb);
    
    public Callbacks callbacks();
    
    /**
     * @sharpen.property
     */
    public ObjectContainerBase container();
    
    /**
     * @sharpen.property
     */
    public Transaction transaction();
    
    public NativeQueryHandler getNativeQueryHandler();

    public ClassMetadata classMetadataForReflectClass(ReflectClass reflectClass);

    public ClassMetadata classMetadataForName(String name);
    
    public ClassMetadata classMetadataForID(int id);

    /**
     * @sharpen.property
     */
    public HandlerRegistry handlers();
    
    /**
     * @sharpen.property
     */
    public Config4Impl configImpl();
    
    public <R> R syncExec(Closure4<R> block);
    
    public int instanceCount(ClassMetadata clazz, Transaction trans);
    
    /**
     * @sharpen.property
     */
    public boolean isClient();

	public void storeAll(Transaction trans, Iterator4 objects);

	public UpdateDepthProvider updateDepthProvider();

	public EventRegistryImpl newEventRegistry();
}
