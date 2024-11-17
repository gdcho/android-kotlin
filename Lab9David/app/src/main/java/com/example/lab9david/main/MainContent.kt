package com.example.lab9david.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.lab9david.data.LocalUser

@Composable
fun MainContent(userState: UserState, signupState: SignupState) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomLabeledTextField("uid:", signupState.uid?.toString() ?: "") { newUid ->
            signupState.onUidChanged(newUid)
        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomLabeledTextField("name:", signupState.name) { newName ->
            signupState.onNameChanged(newName)
        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomLabeledTextField("email:", signupState.email) { newEmail ->
            signupState.onEmailChanged(newEmail)
        }

        Spacer(modifier = Modifier.height(20.dp))

        ButtonRow(userState, signupState)

        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(userState.users) { user ->
                UserItem(user = user, onUserClicked = { selectedUser ->
                    signupState.populateFieldsWithSelectedUser(selectedUser)
                }, onDeleteClicked = { userToDelete ->
                    userState.delete(userToDelete)
                })
            }
        }
    }
}

@Composable
fun CustomLabeledTextField(label: String, value: String, onValueChanged: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 70.dp, bottom = 4.dp)
        )
        CustomTextField(
            label = label,
            value = value,
            onValueChanged = onValueChanged,
        )
    }
}

@Composable
fun ButtonRow(userState: UserState, signupState: SignupState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StyledButton("Add") {
            val user = LocalUser(
                uid = signupState.uid, userName = signupState.name, email = signupState.email
            )
            userState.add(user)
        }
        StyledButton("Refresh") {
            userState.refresh()
        }
    }
}

@Composable
fun StyledButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(4.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp)
    ) {
        Text(text, fontSize = 22.sp)
    }
}