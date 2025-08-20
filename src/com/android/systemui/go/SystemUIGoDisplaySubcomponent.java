/*
 * Copyright (C) 2025 The Android Open Source Project
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

package com.android.systemui.go;

import android.annotation.NonNull;

import com.android.systemui.display.dagger.PerDisplaySystemUIModule;
import com.android.systemui.display.dagger.SystemUIDisplaySubcomponent;
import com.android.systemui.display.dagger.SystemUIDisplaySubcomponent.PerDisplaySingleton;
import com.android.systemui.display.dagger.ReferenceSysUIDisplaySubcomponent;

import dagger.BindsInstance;
import dagger.Subcomponent;

/**
 * SystemUIGo specific {@link Subcomponent} for SysUI classes that should be instantiated once per
 * display.
 *
 * <p>For more information, see documentation on the parent {@link SystemUIDisplaySubcomponent}.
 */
@PerDisplaySingleton
@Subcomponent(
        modules = {
                PerDisplaySystemUIModule.class,
                PerDisplaySystemUIGoModule.class,
        })
public interface SystemUIGoDisplaySubcomponent extends ReferenceSysUIDisplaySubcomponent {

    /** The factory for this subcomponent. */
    @Subcomponent.Factory
    interface Factory extends ReferenceSysUIDisplaySubcomponent.Factory {
        @Override
        @NonNull
        SystemUIGoDisplaySubcomponent create(@BindsInstance @DisplayId int displayId);
    }
}
