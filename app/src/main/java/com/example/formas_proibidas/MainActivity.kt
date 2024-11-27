package com.example.formas_proibidas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.formas_proibidas.ui.theme.FormasproibidasTheme
import java.text.Normalizer.Form

// Define cores personalizadas
val azul2 = Color(0xFF90E0EF)  // Azul claro
val azul = Color(0xFFFFAFE9F4) // Outro tom de azul

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormasproibidasTheme {
                Inicio()  // Chama a tela inicial da aplicação
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio() {
    val navController = rememberNavController()  // Lembra o controlador de navegação
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Define as rotas para navegação
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { ConteudoLogin(navController, innerPadding) }
                    composable("cadastro") { ConteudoCirculo(navController) }
                    composable("cadastro_efetuado") { CadastroEfetuado(navController) }
                    composable("telaformas") { TelaFormas(navController) }
                    composable("AreaQuadrado") {Calc_Area_Quadrado(navController)  }
                    composable("AreaTriângulo") { Calc_Area_Triângulo(navController) }
                    composable("AreaCirculo") { Calc_Area_Circulo(navController) }
                    composable("AreaLosango") { Calc_Area_Losango(navController)  }
                    composable("AreaCubo") {Calc_Area_Cubo(navController)  }
                    composable("AreaParalelogramo") {Calc_Area_Paralelogramo(navController)  }
                    composable("AreaRetangulo") {Calc_Area_Retangulo(navController)  }
                    composable("AreaCubóide") {Calc_Area_Cuboide(navController)  }
                }
            }
        }
    )
}

@Composable
fun ConteudoLogin(navController: NavController, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ativo_1_1),  // Logo do aplicativo
            contentDescription = "Logo Aplicativo",
            modifier = Modifier
                .size(width = 150.dp, height = 150.dp)
                .padding(bottom = 16.dp)
        )
        Text(text = "All the Forms", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.padding(top = 70.dp))

        Button(
            onClick = {
                navController.navigate("telaformas")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = azul2,
                contentColor = Color.Black
            ),
            modifier = Modifier.size(width = 230.dp, height = 38.dp)
        ) {
            Text("Iniciar Aplicação", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.padding(top = 47.dp))

        Button(
            onClick = {
                navController.navigate("cadastro")
            },
            modifier = Modifier.size(width = 250.dp, height = 38.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = azul2,
                contentColor = Color.Black
            )
        ) {
            Text("Faça seu cadastro", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun ConteudoCirculo(navController: NavController) {
    var nome_completo by remember { mutableStateOf("") }  // Campo de nome
    var meu_email by remember { mutableStateOf("") }       // Campo de email
    var minha_senha by remember { mutableStateOf("") }     // Campo de senha
    var confirmar_senha by remember { mutableStateOf("") } // Campo de confirmação de senha
    var senhaVisivel by remember { mutableStateOf(false) } // Controla a visibilidade da senha
    var confirmarSenhaVisivel by remember { mutableStateOf(false) } // Controla a visibilidade da confirmação de senha

    Column(
        modifier = Modifier
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),  // Imagem de fundo
                contentScale = ContentScale.Crop
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Crie sua conta", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.padding(top = 47.dp))

        // Nome Completo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp)
        ) {
            Text(
                text = "Nome Completo",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        OutlinedTextField(
            value = nome_completo,
            onValueChange = { newtext -> nome_completo = newtext },
            modifier = Modifier
                .width(364.dp)
                .height(45.dp),
            textStyle = TextStyle(fontSize = 12.sp),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.padding(top = 32.dp))

        // E-mail
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp)
        ) {
            Text(
                text = "E-mail",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        OutlinedTextField(
            value = meu_email,
            onValueChange = { newtext -> meu_email = newtext },
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable._icon__envelope_icon_),
                    contentDescription = "Logo Email",
                    modifier = Modifier.size(20.dp)
                )
            },
            modifier = Modifier
                .width(365.dp)
                .height(45.dp),
            textStyle = TextStyle(fontSize = 12.sp),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.padding(top = 32.dp))

        // Senha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp)
        ) {
            Text(
                text = "Senha",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        OutlinedTextField(
            value = minha_senha,
            onValueChange = { newtext -> minha_senha = newtext },
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.logo_senha),
                    contentDescription = "Logo_Senha",
                    modifier = Modifier.size(20.dp)
                )
            },
            trailingIcon = {
                IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                    Image(
                        painter = painterResource(R.drawable.eye_open_icon),  // Ícone de olhinho
                        contentDescription = "Mostrar Senha",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            modifier = Modifier
                .width(364.dp)
                .height(45.dp),
            textStyle = TextStyle(fontSize = 12.sp),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(top = 32.dp))

        // Confirmar Senha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp)
        ) {
            Text(
                text = "Confirmar Senha",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        OutlinedTextField(
            value = confirmar_senha,
            onValueChange = { newtext -> confirmar_senha = newtext },
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.logo_senha),
                    contentDescription = "Logo_Senha",
                    modifier = Modifier.size(20.dp)
                )
            },
            trailingIcon = {
                IconButton(onClick = { confirmarSenhaVisivel = !confirmarSenhaVisivel }) {
                    Image(
                        painter = painterResource(R.drawable.eye_open_icon),  // Ícone de olhinho
                        contentDescription = "Mostrar Senha",
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            modifier = Modifier
                .width(364.dp)
                .height(45.dp),
            textStyle = TextStyle(fontSize = 12.sp),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = if (confirmarSenhaVisivel) VisualTransformation.None else PasswordVisualTransformation()
        )

        Button(
            onClick = {
                navController.navigate("cadastro_efetuado")
            },
            modifier = Modifier
                .padding(top = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = azul2,
                contentColor = Color.Black
            )
        ) {
            Text("Cadastrar", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}


@Composable
fun CadastroEfetuado(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Conteúdo da coluna
            Image(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "Logo de checado",
                modifier = Modifier.size(width = 65.dp, height = 65.dp)
            )
            Spacer(modifier = Modifier.padding(top = 32.dp))

            Text("Cadastro Efetuado com sucesso", fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold)

            Button(
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = azul2,
                    contentColor = Color.Black
                )
            ) {
                Text("Ir para a Tela Inicial")  // Texto dentro do Button
            }


        }
    }
}

@Composable
fun TelaFormas(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
                .verticalScroll(rememberScrollState()) // Permite rolar a tela verticalmente
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }

            // Coluna centralizada para os botões
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 150.dp), // Alinha os botões com um espaço do topo
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center // Centraliza os botões verticalmente
            ) {
                // Area do Quadrado
                Button(
                    onClick = {
                        navController.navigate("AreaQuadrado")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.square),  //   imagem
                        contentDescription = "Ícone de Tela Inicial",
                        modifier = Modifier.size(24.dp)  // Tamanho da imagem
                    )
                    Spacer(modifier = Modifier.width(8.dp))  // Espaço entre a imagem e o texto
                    Text("Área do Quadrado")
                }

                // Area do Triângulo
                Button(
                    onClick = {
                        navController.navigate("AreaTriângulo")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.triangle),
                        contentDescription = "Ícone do Triângulo",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Área do Triângulo")
                }

                // Area do Círculo
                Button(
                    onClick = {
                        navController.navigate("AreaCirculo")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.circulo),
                        contentDescription = "Ícone do Círculo",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Área do Círculo")
                }

                // Area do Losango
                Button(
                    onClick = {
                        navController.navigate("AreaLosango")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.losango),
                        contentDescription = "Ícone do Losango",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Área do Losango")
                }
                // Are do Cubo
                Button(
                    onClick = {
                        navController.navigate("AreaCubo")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cubo),
                        contentDescription = "Ícone do Losango",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Área do Cubo")
                }

                // Are do Cubóide
                Button(
                    onClick = {
                        navController.navigate("AreaCubóide")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cub_ide),
                        contentDescription = "Ícone do Cubóide",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Área do Cubóide")
                }

                // Are do Paralelogramo
                Button(
                    onClick = {
                        navController.navigate("AreaParalelogramo")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paralelogramo),
                        contentDescription = "Ícone do Losango",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Área do Paralelogramo")
                }
                // Are do Retangulo
                Button(
                    onClick = {
                        navController.navigate("AreaRetangulo")
                    },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul2,
                        contentColor = Color.Black
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.retangulo),
                        contentDescription = "Ícone do Retângulo",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Área do Retângulo")
                }
            }
        }
    }
}



@Composable
fun Calc_Area_Quadrado(navController: NavController) {
    // Variáveis de estado para o valor do lado e o resultado
    var lado by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Quadrado",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada
                    OutlinedTextField(
                        value = lado,
                        onValueChange = { lado = it },
                        label = { Text("Digite o valor do lado") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {

                            val ladoDouble = lado.toDoubleOrNull()
                            if (ladoDouble != null) {
                                resultado = "Área: ${(ladoDouble * ladoDouble)}"
                            } else {
                                resultado = "Por favor, insira um valor válido!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Calc_Area_Triângulo(navController: NavController) {
    // Variáveis de estado para base, altura e resultado
    var base by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Triângulo",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a base
                    OutlinedTextField(
                        value = base,
                        onValueChange = { base = it },
                        label = { Text("Digite o valor da base") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a altura
                    OutlinedTextField(
                        value = altura,
                        onValueChange = { altura = it },
                        label = { Text("Digite o valor da altura") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {
                            val baseDouble = base.toDoubleOrNull()
                            val alturaDouble = altura.toDoubleOrNull()
                            if (baseDouble != null && alturaDouble != null) {
                                resultado = "Área: ${(baseDouble * alturaDouble) / 2}"
                            } else {
                                resultado = "Por favor, insira valores válidos!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun Calc_Area_Circulo(navController: NavController) {
    // Variáveis de estado para o raio e o resultado
    var raio by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Círculo",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para o raio
                    OutlinedTextField(
                        value = raio,
                        onValueChange = { raio = it },
                        label = { Text("Digite o valor do raio") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {
                            val raioDouble = raio.toDoubleOrNull()
                            if (raioDouble != null) {
                                val area = Math.PI * raioDouble * raioDouble
                                resultado = "Área: %.2f".format(area)
                            } else {
                                resultado = "Por favor, insira um valor válido!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Calc_Area_Losango(navController: NavController) {
    // Variáveis de estado para as diagonais e o resultado
    var diagonal1 by remember { mutableStateOf("") }
    var diagonal2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Losango",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a primeira diagonal
                    OutlinedTextField(
                        value = diagonal1,
                        onValueChange = { diagonal1 = it },
                        label = { Text("Digite o valor da primeira diagonal (D₁)") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a segunda diagonal
                    OutlinedTextField(
                        value = diagonal2,
                        onValueChange = { diagonal2 = it },
                        label = { Text("Digite o valor da segunda diagonal (D₂)") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {
                            val d1 = diagonal1.toDoubleOrNull()
                            val d2 = diagonal2.toDoubleOrNull()
                            if (d1 != null && d2 != null) {
                                resultado = "Área: ${(d1 * d2) / 2}"
                            } else {
                                resultado = "Por favor, insira valores válidos!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Calc_Area_Cubo(navController: NavController) {
    // Variáveis de estado para a aresta e o resultado
    var aresta by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Cubo",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a aresta
                    OutlinedTextField(
                        value = aresta,
                        onValueChange = { aresta = it },
                        label = { Text("Digite o valor da aresta do cubo") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {
                            val arestaDouble = aresta.toDoubleOrNull()
                            if (arestaDouble != null) {
                                val area = 6 * (arestaDouble * arestaDouble) // A área de um cubo é 6 * aresta²
                                resultado = "Área: %.2f".format(area)
                            } else {
                                resultado = "Por favor, insira um valor válido!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Calc_Area_Paralelogramo(navController: NavController) {
    // Variáveis de estado para a base, altura e o resultado
    var base by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Paralelogramo",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a base
                    OutlinedTextField(
                        value = base,
                        onValueChange = { base = it },
                        label = { Text("Digite o valor da base") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a altura
                    OutlinedTextField(
                        value = altura,
                        onValueChange = { altura = it },
                        label = { Text("Digite o valor da altura") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {
                            val baseDouble = base.toDoubleOrNull()
                            val alturaDouble = altura.toDoubleOrNull()
                            if (baseDouble != null && alturaDouble != null) {
                                val area = baseDouble * alturaDouble // A área do paralelogramo é base * altura
                                resultado = "Área: %.2f".format(area)
                            } else {
                                resultado = "Por favor, insira valores válidos!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Calc_Area_Retangulo(navController: NavController) {
    // Variáveis de estado para a base, altura e o resultado
    var base by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Retângulo",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a base
                    OutlinedTextField(
                        value = base,
                        onValueChange = { base = it },
                        label = { Text("Digite o valor da base") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a altura
                    OutlinedTextField(
                        value = altura,
                        onValueChange = { altura = it },
                        label = { Text("Digite o valor da altura") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {
                            val baseDouble = base.toDoubleOrNull()
                            val alturaDouble = altura.toDoubleOrNull()
                            if (baseDouble != null && alturaDouble != null) {
                                val area = baseDouble * alturaDouble // A área do retângulo é base * altura
                                resultado = "Área: %.2f".format(area)
                            } else {
                                resultado = "Por favor, insira valores válidos!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Calc_Area_Cuboide(navController: NavController) {
    // Variáveis de estado para os valores de comprimento, largura, altura e o resultado
    var comprimento by remember { mutableStateOf("") }
    var largura by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = azul)
            .paint(
                painter = painterResource(R.drawable.group_3),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 34.dp) // Margem lateral para alinhar à esquerda
        ) {
            Spacer(modifier = Modifier.height(80.dp)) // Ajuste a altura para descer a imagem

            // Row para organizar imagem e texto lado a lado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Alinha o texto com a imagem
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ativo_1_1),
                    contentDescription = "Logo Aplicativo",
                    modifier = Modifier.size(width = 65.dp, height = 65.dp)
                )

                Spacer(modifier = Modifier.width(16.dp)) // Espaço entre a imagem e o texto

                Text(
                    text = "All The Forms",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                )
            }
        }

        // Coluna centralizada
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card para a calculadora
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.9f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Calculadora de Área do Cubóide",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para o comprimento
                    OutlinedTextField(
                        value = comprimento,
                        onValueChange = { comprimento = it },
                        label = { Text("Digite o valor do comprimento") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a largura
                    OutlinedTextField(
                        value = largura,
                        onValueChange = { largura = it },
                        label = { Text("Digite o valor da largura") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo de entrada para a altura
                    OutlinedTextField(
                        value = altura,
                        onValueChange = { altura = it },
                        label = { Text("Digite o valor da altura") },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Botão para calcular a área
                    Button(
                        onClick = {
                            val comprimentoDouble = comprimento.toDoubleOrNull()
                            val larguraDouble = largura.toDoubleOrNull()
                            val alturaDouble = altura.toDoubleOrNull()
                            if (comprimentoDouble != null && larguraDouble != null && alturaDouble != null) {
                                // A área do cubóide é 2 * (comprimento * largura + comprimento * altura + largura * altura)
                                val area = 2 * (comprimentoDouble * larguraDouble + comprimentoDouble * alturaDouble + larguraDouble * alturaDouble)
                                resultado = "Área: %.2f".format(area)
                            } else {
                                resultado = "Por favor, insira valores válidos!"
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Calcular")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Card para exibição do resultado
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = azul2),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = resultado,
                            modifier = Modifier.padding(16.dp),
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormasproibidasTheme {
        Inicio()
    }
}

@Preview
@Composable
private fun PreviewConteudoCirculo() {
    FormasproibidasTheme {
        ConteudoCirculo(rememberNavController())
    }
}

@Preview
@Composable
private fun PreviewCadastroEfetuado() {
    FormasproibidasTheme {
        CadastroEfetuado(rememberNavController())
    }
}

@Preview
@Composable
private fun PreviewTelaFormas() {
    FormasproibidasTheme {
        TelaFormas(rememberNavController())
    }
    
}

@Preview
@Composable
private fun PreviewAreadoQuadrado() {
    FormasproibidasTheme {
        Calc_Area_Quadrado(rememberNavController())
    }
    
}

@Preview
@Composable
private fun PreviewAreadoTriângulo() {
    FormasproibidasTheme {
        Calc_Area_Triângulo(rememberNavController())
    }
    
}

@Preview
@Composable
private fun PreviewAreadoCirculo() {
    FormasproibidasTheme {
        Calc_Area_Circulo(rememberNavController())
    }
}

@Preview
@Composable
private fun PreviewAreadoLosango() {
    FormasproibidasTheme {
        Calc_Area_Losango(rememberNavController())
    }

}

@Preview
@Composable
private fun PreviewAreadoCubo() {
    FormasproibidasTheme {
        Calc_Area_Cubo(rememberNavController())
    }
    
}

@Preview
@Composable
private fun PreviewAreadoParalelogramo() {
    FormasproibidasTheme {
        Calc_Area_Paralelogramo(rememberNavController())
    }
    
}

@Preview
@Composable
private fun PreviewAreadoRetangulo() {
    FormasproibidasTheme {
        Calc_Area_Retangulo(rememberNavController())
    }
    
}

@Preview
@Composable
private fun PreviewAreadoCuboide() {
    FormasproibidasTheme {
        Calc_Area_Cuboide(rememberNavController())
    }
    
}