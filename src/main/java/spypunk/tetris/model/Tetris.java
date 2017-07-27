/*
 * Copyright © 2016-2017 spypunk <spypunk@gmail.com>
 *
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package spypunk.tetris.model;

import java.net.URI;
import java.util.List;

import com.google.common.collect.Lists;

public class Tetris {

    public enum State {
        STOPPED,
        RUNNING {
            @Override
            public State onPause() {
                return PAUSED;
            }
        },
        PAUSED {
            @Override
            public State onPause() {
                return RUNNING;
            }
        },
        GAME_OVER;

        public State onPause() {
            return this;
        }
    }

    private String name;

    private String version;

    private URI projectURI;

    private TetrisInstance tetrisInstance;

    private State state;

    private boolean mute;

    private List<TetrisEvent> tetrisEvents = Lists.newArrayList();

    public static final class Builder {

        private final Tetris tetris = new Tetris();

        private Builder() {
        }

        public static Builder instance() {
            return new Builder();
        }

        public Builder setName(final String name) {
            tetris.setName(name);
            return this;
        }

        public Builder setVersion(final String version) {
            tetris.setVersion(version);
            return this;
        }

        public Builder setProjectURI(final URI projectURI) {
            tetris.setProjectURI(projectURI);
            return this;
        }

        public Builder setState(final State state) {
            tetris.setState(state);
            return this;
        }

        public Tetris build() {
            return tetris;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public URI getProjectURI() {
        return projectURI;
    }

    public void setProjectURI(final URI projectURI) {
        this.projectURI = projectURI;
    }

    public TetrisInstance getTetrisInstance() {
        return tetrisInstance;
    }

    public void setTetrisInstance(final TetrisInstance tetrisInstance) {
        this.tetrisInstance = tetrisInstance;
    }

    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(final boolean mute) {
        this.mute = mute;
    }

    public List<TetrisEvent> getTetrisEvents() {
        return tetrisEvents;
    }

    public void setTetrisEvents(final List<TetrisEvent> tetrisEvents) {
        this.tetrisEvents = tetrisEvents;
    }
}
