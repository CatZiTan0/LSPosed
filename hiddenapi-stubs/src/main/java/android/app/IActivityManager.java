/*
 * This file is part of LSPosed.
 *
 * LSPosed is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LSPosed is distributed the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LSPosed.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2021 LSPosed Contributors
 */

package android.app;

import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

import androidx.annotation.RequiresApi;

public interface IActivityManager extends IInterface {
    @RequiresApi(30)
    int broadcastIntentWithFeature(IApplicationThread caller, String callingFeatureId,
                                   Intent intent, String resolvedType, IIntentReceiver resultTo, int resultCode,
                                   String resultData, Bundle map, String[] requiredPermissions,
                                   int appOp, Bundle options, boolean serialized, boolean sticky, int userId) throws RemoteException;

    int broadcastIntent(IApplicationThread caller, Intent intent,
                        String resolvedType, IIntentReceiver resultTo, int resultCode,
                        String resultData, Bundle map, String[] requiredPermissions,
                        int appOp, Bundle options, boolean serialized, boolean sticky, int userId) throws RemoteException;

    void forceStopPackage(String packageName, int userId);

    boolean startUserInBackground(int userid);

    Intent registerReceiver(IApplicationThread caller, String callerPackage,
                            IIntentReceiver receiver, IntentFilter filter,
                            String requiredPermission, int userId, int flags);
    Intent registerReceiverWithFeature(IApplicationThread caller, String callerPackage,
                                       String callingFeatureId, IIntentReceiver receiver, IntentFilter filter,
                                       String requiredPermission, int userId, int flags);

    int bindService(IApplicationThread caller, IBinder token, Intent service,
                    String resolvedType, IServiceConnection connection, int flags,
                    String callingPackage, int userId);

    boolean unbindService(IServiceConnection connection);

    abstract class Stub extends Binder implements IActivityManager {

        public static IActivityManager asInterface(IBinder obj) {
            throw new UnsupportedOperationException();
        }
    }
}
