/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.launcher.settings;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.launcher.game.GameJob;
import org.terasology.launcher.game.GameSettings;
import org.terasology.launcher.util.JavaHeapSize;
import org.terasology.launcher.util.LogLevel;

/**
 * Created by Skaldarnar on 30.01.2016.
 */
public abstract class LauncherSettings implements GameSettings {

    private static final Logger logger = LoggerFactory.getLogger(LauncherSettings.class);

    public abstract void load() throws IOException;

    public abstract void store() throws IOException;

    public synchronized void init() {
        logger.trace("Init launcher settings ...");

        initLocale();
        initJob();
        initBuildVersion();
        initLastBuildNumber();
        initMaxHeapSize();
        initInitialHeapSize();
        initSearchForLauncherUpdates();
        initCloseLauncherAfterGameStart();
        initSaveDownloadedFiles();
        initGameDirectory();
        initGameDataDirectory();
        initUserJavaParameters();
        initUserGameParameters();
        initLogLevel();
    }

    // --------------------------------------------------------------------- //
    // INIT
    // --------------------------------------------------------------------- //

    protected abstract void initInitialHeapSize();

    protected abstract void initSearchForLauncherUpdates();

    protected abstract void initCloseLauncherAfterGameStart();

    protected abstract void initSaveDownloadedFiles();

    protected abstract void initGameDirectory();

    protected abstract void initGameDataDirectory();

    protected abstract void initUserJavaParameters();

    protected abstract void initUserGameParameters();

    protected abstract void initLogLevel();

    protected abstract void initMaxHeapSize();

    protected abstract void initLastBuildNumber();

    protected abstract void initLocale();

    protected abstract void initJob();

    protected abstract void initBuildVersion();

    // --------------------------------------------------------------------- //
    // GETTERS
    // --------------------------------------------------------------------- //

    public abstract Locale getLocale();

    public abstract GameJob getJob();

    public abstract Integer getBuildVersion(GameJob job);

    public abstract Integer getLastBuildNumber(GameJob job);

    public abstract JavaHeapSize getMaxHeapSize();

    public abstract JavaHeapSize getInitialHeapSize();

    public abstract String getUserJavaParameters();

    public synchronized List<String> getUserJavaParameterList() {
        return Arrays.asList(getUserJavaParameters().split("\\s+"));
    }

    public abstract String getUserGameParameters();

    public synchronized List<String> getUserGameParameterList() {
        return Arrays.asList(getUserGameParameters().split("\\s+"));
    }

    public abstract LogLevel getLogLevel();

    public abstract File getGameDirectory();

    public abstract File getGameDataDirectory();

    public abstract boolean isSearchForLauncherUpdates();

    public abstract boolean isCloseLauncherAfterGameStart();

    public abstract boolean isKeepDownloadedFiles();

    // --------------------------------------------------------------------- //
    // SETTERS
    // --------------------------------------------------------------------- //

    public abstract void setLocale(Locale locale);

    public abstract void setJob(GameJob job);

    public abstract void setBuildVersion(int version, GameJob job);

    public abstract void setLastBuildNumber(Integer lastBuildNumber, GameJob job);

    public abstract void setMaxHeapSize(JavaHeapSize maxHeapSize);

    public abstract void setInitialHeapSize(JavaHeapSize initialHeapSize);

    public abstract void setUserJavaParameters(String userJavaParameters);

    public abstract void setUserGameParameters(String userGameParameters);

    public abstract void setSearchForLauncherUpdates(boolean searchForLauncherUpdates);

    public abstract void setCloseLauncherAfterGameStart(boolean closeLauncherAfterGameStart);

    public abstract void setKeepDownloadedFiles(boolean keepDownloadedFiles);

    public abstract void setGameDirectory(File gameDirectory);

    public abstract void setGameDataDirectory(File gameDataDirectory);
}
