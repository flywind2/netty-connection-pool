package com.github.akurilov.netty.connection.pool.mock;

import com.github.akurilov.netty.connection.pool.MultiNodeConnPoolImpl;
import com.github.akurilov.netty.connection.pool.NonBlockingConnPool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.pool.ChannelPoolHandler;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 Created by andrey on 12.05.17.
 */
public final class MultiNodeConnPoolMock
extends MultiNodeConnPoolImpl
implements NonBlockingConnPool {

	public MultiNodeConnPoolMock(
		final String[] nodes, final Bootstrap bootstrap, final ChannelPoolHandler connPoolHandler,
		final int defaultPort, final int connFailSeqLenLimit
	) {
		super(nodes, bootstrap, connPoolHandler, defaultPort, connFailSeqLenLimit, 0, TimeUnit.SECONDS);
	}

	protected final Channel connect(final String addr) {
		final Channel c = new EmbeddedChannel();
		c.attr(ATTR_KEY_NODE).set(addr);
		return c;
	}
}
