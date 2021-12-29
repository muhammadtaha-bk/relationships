package com.spring.relationships.service.implimentation;

import com.blueconic.browscap.*;
import com.spring.relationships.service.ClientService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public String getClientData(String userAgent) throws IOException, ParseException {
        UserAgentParser parser = new UserAgentService().loadParser();
        Capabilities capabilities = parser.parse(userAgent);
        return "Browser : " + capabilities.getValue(BrowsCapField.BROWSER) + "\n"
                + "Platform : " + capabilities.getValue(BrowsCapField.PLATFORM) + "\n"
                + "DeviceType : " + capabilities.getValue(BrowsCapField.DEVICE_TYPE);
    }
}
