package ch26_socket.simpleGUI.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.google.gson.Gson;

import ch26_socket.simpleGUI.client.dto.RequestBodyDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class ClientReceiver extends Thread {
	@Override
	public void run() {
		SimpleGUIClient simpleGUIClient = SimpleGUIClient.getInstance();
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(simpleGUIClient.getSocket().getInputStream()));
				String requestBody = bufferedReader.readLine();

				reqestController(requestBody);
				join(500);

			} catch (IOException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

	private void reqestController(String requestBody) {
		Gson gson = new Gson();
		String resource = gson.fromJson(requestBody, RequestBodyDto.class).getResourse();

		switch (resource) {
		case "updateRoomList":
			List<String> roomList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
			SimpleGUIClient.getInstance().getRoomListModel().clear();
			SimpleGUIClient.getInstance().getRoomListModel().addAll(roomList);

			break;

		case "showMessage":
			String messageContent = (String) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
			SimpleGUIClient.getInstance().getChattingTextArea().append(messageContent + "\n");

			break;

		case "updateUserList":
			List<String> usernameList = (List<String>) gson.fromJson(requestBody, RequestBodyDto.class).getBody();
			SimpleGUIClient.getInstance().getUserListModel().clear();
			SimpleGUIClient.getInstance().getUserListModel().addAll(usernameList);

			break;
		}
	}
}
