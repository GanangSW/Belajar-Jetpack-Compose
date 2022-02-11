package com.gsw.belajarjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.gsw.belajarjetpackcompose.ui.theme.BelajarJetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

// Hari ini kita akan belajar scaffold

@Composable
fun Greeting() {
//    Buat variable untuk state
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()

//    Scaffold
    Scaffold(
        scaffoldState = scaffoldState,
//    Scaffold TopBar
        topBar = {
            TopAppBar(
                title = { Text(text = "Top Bar") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { scaffoldState.drawerState.open() }
                    }, content = {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    })
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ },
                        content = {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        })
                    IconButton(onClick = { /*TODO*/ },
                        content = {
                            Icon(Icons.Default.MoreVert, contentDescription = "Search")
                        })
                }
            )
        },
//        Scaffold FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = "Icon"
                )
            }
        },
//        scaffold BottomBar
        bottomBar = {
            BottomNavBar(
                items = navItems,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        },
        drawerContent = { Drawer(
            scaffoldState = scaffoldState,
            scope = scope,
            navController = navController,
            navItems = drawerNavItems
        )}
        ,
        content = {
            Navigation(navController = navController)
        }
    )
}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

val navItems = listOf(
    BottomNavItem(name = "Dashboard", route = "dashboard", icon = Icons.Default.Home),
    BottomNavItem(
        name = "Notification",
        route = "notification",
        icon = Icons.Default.Notifications
    ),
    BottomNavItem(name = "Profile", route = "profile", icon = Icons.Default.Person),
)

data class DrawerNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

val drawerNavItems = listOf(
    DrawerNavItem(name = "Dashboard", route = "dashboard", icon = Icons.Default.Home),
    DrawerNavItem(
        name = "Notification",
        route = "notification",
        icon = Icons.Default.Notifications
    ),
    DrawerNavItem(name = "Profile", route = "profile", icon = Icons.Default.Person),
)


@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        elevation = 5.dp
    ) {
        items.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected, onClick = { onItemClick(it) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(it.icon, contentDescription = it.name)
                        if (selected) Text(text = it.name)
                    }
                }
            )
        }
    }
}


@Composable
fun Drawer(
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    navController: NavController,
    navItems: List<DrawerNavItem>
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
        navItems.forEach {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(40.dp)
                    .clickable {
                        scope.launch { scaffoldState.drawerState.close() }
                        navController.navigate(it.route)
                    }) {

                Icon(it.icon, contentDescription = it.name)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = it.name,
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable(route = "dashboard") { Dashboard() }
        composable(route = "notification") { Notification() }
        composable(route = "profile") { Profile() }
    }
}

@Composable
fun Profile() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Profile")
    }
}

@Composable
fun Notification() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Notification")
    }
}

@Composable
fun Dashboard() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Dashboard")
    }
}





