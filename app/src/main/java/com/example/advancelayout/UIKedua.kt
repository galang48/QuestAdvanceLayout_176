package com.example.advancelayout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileSimpleScreen(
    name: String = "Lee Ruby",
    handle: String = "@rubyfnql",
    role: String = "Saya istri Galang",
    handleResourceName:String = stringResource(R.string.nama),
    modifier: Modifier = Modifier
) {
    val bg = Brush.verticalGradient(listOf(Color(0xFF111420), Color(0xFF0C0E16)))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(horizontal = 16.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .widthIn(max = 420.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .size(108.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2A2F3F))
                    .border(2.dp, Color(0xFF3E4B6A), CircleShape)
            ) {
                    Image(
                        painter = painterResource(R.drawable.maruby),
                        contentDescription = "Foto Profil",
                        modifier = Modifier.size(96.dp).clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            // "Ikon" sosial sederhana (huruf saja agar tanpa dependensi ikon)
        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialDot(color = Color(0xFF4C7DFF), content = { Text("f", color = Color.White, fontSize = 20.sp) })
            SocialDot(color = Color(0xFFFF0000), content = { Text("G+", color = Color.White, fontSize = 20.sp) })
            SocialDot(color = Color(0xFF00C2FF), content = { Text("t", color = Color.White, fontSize = 20.sp) })
            SocialDot(color = Color(0xFF0A66C2), content = { Text("in", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold) })
        }

            Spacer(Modifier.height(12.dp))

            Text(name, color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            Text(handle, color = Color(0xFFB9C5E3), fontSize = 14.sp)
            Text(
                role,
                color = Color(0xFFDDE7FF),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 6.dp)
            )

            Spacer(Modifier.height(20.dp))

            // Menu bergaya pill (tanpa ikon paket eksternal)
        MenuPill(
            title = stringResource(R.string.menu1),
            icon = { Icon(Icons.Outlined.Face, null, tint = Color.White) }
        )
        Spacer(Modifier.height(12.dp))
        MenuPill(
            title = stringResource(R.string.menu2),
            icon = { Icon(Icons.Outlined.Favorite, null, tint = Color.White) }
        )
        Spacer(Modifier.height(12.dp))
        MenuPill(
            title = stringResource(R.string.menu3),
            icon = { Icon(Icons.Outlined.Settings, null, tint = Color.White) }
        )

        Spacer(Modifier.weight(1f))

        Spacer(Modifier.height(265.dp))

        Text(
            text = "© 2025 $handleResourceName",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF6D738A))
        )


        Spacer(Modifier.height(265.dp))

        Text(
            text = "© 2025 $handleResourceName",
            color = Color(0xFF8190AF),
            fontSize = 12.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        }


    }

@Composable
private fun SocialDot(label: String, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = Color.White.copy(alpha = 0.06f),
        shape = CircleShape,
        modifier = Modifier.size(36.dp)
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(label, color = Color(0xFFBFD2FF), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
private fun MenuPillSimple(title: String, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.08f)),
        elevation = CardDefaults.cardElevation(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.White.copy(alpha = 0.18f), RoundedCornerShape(26.dp))
    ) {
        Row(
            Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // bulatan kecil kiri sebagai placeholder ikon
            Box(
                Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.10f)),
                contentAlignment = Alignment.Center
            ) {
                Text("•", color = Color(0xFFE5ECFF))
            }

            Spacer(Modifier.width(12.dp))
            Text(title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))

            // panah kanan sederhana (tanpa ikon)
            Box(
                Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.10f)),
                contentAlignment = Alignment.Center
            ) {
                Text("›", color = Color(0xFFCFDAFF), fontSize = 16.sp)
            }
        }
    }
}

@Composable
private fun SocialDot(
    color: Color,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) { content() }
}

@Composable
private fun MenuPill(
    title: String,
    icon: @Composable () -> Unit
) {
    val pillShape = RoundedCornerShape(22.dp)
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = pillShape,
        color = Color.DarkGray
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color.DarkGray),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }

            Spacer(Modifier.width(14.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.9f)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewProfileSimple() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        ProfileSimpleScreen()
    }

}
