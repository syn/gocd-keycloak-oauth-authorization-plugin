/*
 * Copyright 2017 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.authorization.keycloak.executors;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import static cd.go.authorization.keycloak.utils.Util.readResourceBytes;
import static java.util.Base64.getEncoder;

public class GetPluginIconRequestExecutor implements RequestExecutor {
    private static final Gson GSON = new Gson();

    @Override
    public GoPluginApiResponse execute() throws Exception {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content_type", getContentType());
        jsonObject.addProperty("data", getEncoder().encodeToString(readResourceBytes(getIcon())));
        return DefaultGoPluginApiResponse.success( GSON.toJson(jsonObject));

    }

    private String getContentType() {
        return "image/png";
    }

    private String getIcon() {
        return "/Catalyst-login.png";
    }
}
